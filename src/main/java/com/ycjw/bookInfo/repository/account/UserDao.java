package com.ycjw.bookInfo.repository.account;

import com.ycjw.bookInfo.model.account.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {
    User findByAccount(String account);
}
