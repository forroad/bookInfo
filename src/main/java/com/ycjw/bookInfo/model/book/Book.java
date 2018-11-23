package com.ycjw.bookInfo.model.book;

public class Book {
    //id
    private String id;
    //书名
    private String name;
    //作者
    private String author;
    //简介
    private String shortInfo;
    //状态,默认在馆
    private Status status = Status.in;

    //书籍状态
    public enum Status{
        //在馆，不在馆，遗失
        in,not_in,lose
    }

    public Book(String name, String author, String shortInfo, Status status) {
        this.name = name;
        this.author = author;
        this.shortInfo = shortInfo;
        this.status = status;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
