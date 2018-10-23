package com.ycjw.bookInfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.ycjw.bookInfo.repository")
public class MongoDBConfig {
}
