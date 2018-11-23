package com.ycjw.bookInfo.service.book.impl;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.account.User;
import com.ycjw.bookInfo.model.book.Book;
import com.ycjw.bookInfo.model.book.BorrowRecord;
import com.ycjw.bookInfo.repository.account.UserDao;
import com.ycjw.bookInfo.repository.book.BookDao;
import com.ycjw.bookInfo.repository.book.BorrowRecordDao;
import com.ycjw.bookInfo.service.book.OpBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class OpBookServiceImpl implements OpBookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;
    @Autowired
    BorrowRecordDao borrowRecordDao;
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public BorrowRecord borrowBook(String userId, String bookId) throws ExceptionZyc {
        //检查参数是否为空
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(bookId)){
            //参数为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询用户
        User user = userDao.findById(userId).orElse(null);
        //用户为空，参数错误
        if(user == null){
            //用户不存在
            throw  ExceptionZyc.USER_IS_NOT_EXIST;
        }
        //查询书籍
        Book book = bookDao.findById(bookId).orElse(null);
        //书籍为空
        if(book == null){
            //书籍不存在
            throw ExceptionZyc.BOOK_IS_NOT_EXIST;
        }
        //书籍不在馆
        if(book.getStatus().equals(Book.Status.not_in)){
            //书籍不在馆，抛出异常
            throw ExceptionZyc.BOOK_IS_NOT_IN;
        }
        //初始化借书记录
        BorrowRecord borrowRecord = new BorrowRecord();
        //设置借阅用户
        borrowRecord.setUser(user);
        //设置借阅书籍
        borrowRecord.setBook(book);
        //设置借阅时间
        borrowRecord.setBorrowTime(new Date());
        //设置应该还书时间
        borrowRecord.setAppointReturnTime(new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L));
        //设置书籍不在馆
        book.setStatus(Book.Status.not_in);
        //保存借书记录
        borrowRecord = borrowRecordDao.save(borrowRecord);
        //保存书籍信息
        bookDao.save(book);
        //返回数据
        return borrowRecord;
    }

    @Override
    public BorrowRecord returnBook(String borrowRecordId) throws ExceptionZyc {
        //检查参数是否为空
        if(StringUtils.isEmpty(borrowRecordId)){
            //参数为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询借阅记录
        BorrowRecord borrowRecord = borrowRecordDao.findById(borrowRecordId).orElse(null);
        //判断借阅记录是否为空
        if(borrowRecord == null){
            //借阅记录为空
            throw ExceptionZyc.USER_IS_NOT_BORROW_THIS_BOOK;
        }
        //获取借阅书籍实例
        Book book = borrowRecord.getBook();
        //判断书籍是否为空
        if(book == null){
            //书籍实例为空
            throw ExceptionZyc.SERVER_ERROR;
        }
        //判断借阅记录是否为空
        if((!book.getStatus().equals(Book.Status.not_in))){
            throw ExceptionZyc.USER_IS_NOT_BORROW_THIS_BOOK;
        }
        //开始还书,设置还书时间
        borrowRecord.setReturnTime(new Date());
        //设置借阅记录已处理
        borrowRecord.setDeal(true);
        //设置书籍在馆
        book.setStatus(Book.Status.in);
        //保存借阅记录
        borrowRecord = borrowRecordDao.save(borrowRecord);
        //保存书籍信息
        bookDao.save(book);
        //返回数据
        return borrowRecord;
    }

    @Override
    public BorrowRecord payBookMoney(String borrowRecordId, double payMoney) throws ExceptionZyc {
        //检查参数是否为空
        if(StringUtils.isEmpty(borrowRecordId)){
            //参数为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询借阅记录
        BorrowRecord borrowRecord = borrowRecordDao.findById(borrowRecordId).orElse(null);
        //判断借阅记录是否为空
        if(borrowRecord == null){
            //借阅记录为空
            throw ExceptionZyc.USER_IS_NOT_BORROW_THIS_BOOK;
        }
        //获取借阅书籍实例
        Book book = borrowRecord.getBook();
        //判断书籍是否为空
        if(book == null){
            //书籍实例为空
            throw ExceptionZyc.SERVER_ERROR;
        }
        //判断借阅记录是否为空
        if((!book.getStatus().equals(Book.Status.not_in))){
            throw ExceptionZyc.USER_IS_NOT_BORROW_THIS_BOOK;
        }
        //判断赔付金额
        if(payMoney <= 0){
            //赔付金额太少
            throw ExceptionZyc.PAYMONEY_IS_LITTLE;
        }
        //开始赔付,设置配符金额
        borrowRecord.setPayMoney(payMoney);
        //设置借阅记录已处理
        borrowRecord.setDeal(true);
        //书籍遗失，设置书籍遗失信息
        book.setStatus(Book.Status.lose);
        //保存借阅记录
        borrowRecord = borrowRecordDao.save(borrowRecord);
        //保存书籍信息
        bookDao.save(book);
        return borrowRecord;
    }

    @Override
    public List<BorrowRecord> getAllBorrowBooks(String userId) throws ExceptionZyc {
        //判断参数是否为空
        if(StringUtils.isEmpty(userId)){
            //参数为空
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询用户
        User user = userDao.findById(userId).orElse(null);
        //判断用户是否为空
        if(user == null){
            //用户实例为空
            throw  ExceptionZyc.USER_IS_NOT_EXIST;
        }
        //查询用户未处理的借阅记录
        List<BorrowRecord> borrowRecords = borrowRecordDao.findByUserAndIsDeal(user,false);
        return borrowRecords;
    }
}
