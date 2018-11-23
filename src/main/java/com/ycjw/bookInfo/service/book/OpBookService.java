package com.ycjw.bookInfo.service.book;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.book.Book;
import com.ycjw.bookInfo.model.book.BorrowRecord;
import com.ycjw.bookInfo.model.response.Response;

import java.util.List;

public interface OpBookService {
    /**
     *  用户借阅书籍
     * @param userId 借书的用户ID
     * @param bookId 借阅的书籍ID
     * @return  借阅记录
     * @throws ExceptionZyc 可能产生的错误
      */
    BorrowRecord borrowBook(String userId, String bookId) throws ExceptionZyc;

    /**
     *  还书
     * @param borrowRecordId 借阅记录Id
     * @return 借阅记录
     * @throws ExceptionZyc
     */
    BorrowRecord returnBook(String borrowRecordId) throws ExceptionZyc;

    /**
     *  赔付
     * @param borrowRecordId 借阅记录id
     * @param payMoney 赔付的价钱
     * @return 借阅记录
     * @throws ExceptionZyc
     */
    BorrowRecord payBookMoney(String borrowRecordId,double payMoney) throws ExceptionZyc;

    /**
     *  查询用户借阅的所有书籍
     * @param userId 用户ID
     * @return 未处理的借阅记录列表
     * @throws ExceptionZyc 可能产生的错误
     */
    List<BorrowRecord> getAllBorrowBooks(String userId) throws ExceptionZyc;
}
