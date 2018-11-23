package com.ycjw.bookInfo.service.book.impl;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.book.Book;
import com.ycjw.bookInfo.repository.book.BookDao;
import com.ycjw.bookInfo.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public Book addBook(String name, String author, String shortInfo) throws ExceptionZyc {
        //判断信息是否为空
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(author)||StringUtils.isEmpty(shortInfo)){
            //信息为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //参数不为空，新建书籍实例
        Book book = new Book(name,author,shortInfo,Book.Status.in);
        //保存至数据库
        book = bookDao.save(book);
        //返回信息
        return book;
    }

    @Override
    public Book deleteBook(String id) throws ExceptionZyc {
        //判断书籍id是否为空
        if(StringUtils.isEmpty(id)){
            //id为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询书籍
        Book book = bookDao.findById(id).orElse(null);
        //判断书籍是否存在
        if(book == null){
            //书籍不存在，抛出异常
            throw ExceptionZyc.BOOK_IS_NOT_EXIST;
        }
        //书籍存在删除对应书籍
        bookDao.delete(book);
        //返回信息
        return book;
    }

    @Override
    public List<Book> findBook(String name, String author) throws ExceptionZyc {
        //查询书籍
        List<Book> books = bookDao.findByNameLikeOrAuthorLike(name,author);
        //返回信息
        return books;
    }

    @Override
    public Book updateBookName(String id, String newName) throws ExceptionZyc {
        //判断信息是否为空
        if(StringUtils.isEmpty(id)||StringUtils.isEmpty(newName)){
            //信息为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询书籍
        Book book = bookDao.findById(id).orElse(null);
        //判断书籍是否存在
        if(book == null){
            //书籍不存在，抛出异常
            throw ExceptionZyc.BOOK_IS_NOT_EXIST;
        }
        //设置新名称
        book.setName(newName);
        //保存信息
        book = bookDao.save(book);
        //返回信息
        return book;
    }

    @Override
    public Book updateBookAuthor(String id, String newAuthor) throws ExceptionZyc {
        //判断信息是否为空
        if(StringUtils.isEmpty(id)||StringUtils.isEmpty(newAuthor)){
            //信息为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询书籍
        Book book = bookDao.findById(id).orElse(null);
        //判断书籍是否存在
        if(book == null){
            //书籍不存在，抛出异常
            throw ExceptionZyc.BOOK_IS_NOT_EXIST;
        }
        //设置新作者
        book.setAuthor(newAuthor);
        //保存信息
        book = bookDao.save(book);
        //返回信息
        return book;
    }

    @Override
    public Book updateBookShortInfo(String id, String newShortInfo) throws ExceptionZyc {
        //判断信息是否为空
        if(StringUtils.isEmpty(id)||StringUtils.isEmpty(newShortInfo)){
            //信息为空，抛出异常
            throw ExceptionZyc.PARAM_IS_NULL;
        }
        //查询书籍
        Book book = bookDao.findById(id).orElse(null);
        //判断书籍是否存在
        if(book == null){
            //书籍不存在，抛出异常
            throw ExceptionZyc.BOOK_IS_NOT_EXIST;
        }
        //设置新简介
        book.setShortInfo(newShortInfo);
        //保存信息
        book = bookDao.save(book);
        //返回信息
        return book;
    }
}
