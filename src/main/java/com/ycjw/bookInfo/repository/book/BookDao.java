package com.ycjw.bookInfo.repository.book;

import com.ycjw.bookInfo.model.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDao extends MongoRepository<Book,String> {
    List<Book> findByNameLikeOrAuthorLike(String name,String author);
}
