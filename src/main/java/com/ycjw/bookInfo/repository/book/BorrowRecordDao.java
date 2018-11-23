package com.ycjw.bookInfo.repository.book;

import com.ycjw.bookInfo.model.account.User;
import com.ycjw.bookInfo.model.book.Book;
import com.ycjw.bookInfo.model.book.BorrowRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BorrowRecordDao extends MongoRepository<BorrowRecord,String> {
    List<BorrowRecord> findByUserAndIsDeal(User user,Boolean isDeal);
}
