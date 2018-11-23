package com.ycjw.bookInfo.service.book;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.book.Book;

import java.util.List;

public interface BookService {
    /**
     * 添加书籍
     * @param name 书名
     * @param author 作者
     * @param shortInfo 简介
     * @return 添加的书籍实例信息
     * @throws ExceptionZyc 可能产生的错误
     */
    Book addBook(String name,String author,String shortInfo) throws ExceptionZyc;

    /**
     *  删除书籍
     * @param id 书籍的id
     * @return 删除的书籍实例信息
     * @throws ExceptionZyc 可能产生的错误
     */
    Book deleteBook(String id) throws ExceptionZyc;

    /**
     * 通过书名和作者模糊查找书籍
     * @param name 书名
     * @param author 作者
     * @return 查询的信息集合
     */
    List<Book> findBook(String name, String author) throws ExceptionZyc;

    /**
     *  更新书籍的名字
     * @param id 书籍的d
     * @param newName 新书名
     * @return 更新后的书籍信息
     * @throws ExceptionZyc 可能产生的异常
     */
    Book updateBookName(String id,String newName) throws ExceptionZyc;

    /**
     *  更改书籍的作者
     * @param id 书籍id
     * @param newAuthor 新作者
     * @return 更改后的书籍信息
     * @throws ExceptionZyc 可能产生的异常
     */
    Book updateBookAuthor(String id,String newAuthor) throws ExceptionZyc;

    /**
     *  更改书籍的简介
     * @param id 书籍id
     * @param newShortInfo 新简介
     * @return 更改后的书籍信息
     * @throws ExceptionZyc 可能产生的异常
     */
    Book updateBookShortInfo(String id,String newShortInfo) throws ExceptionZyc;
}
