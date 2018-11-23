package com.ycjw.bookInfo.model.book;

import com.ycjw.bookInfo.model.account.User;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//借书记录
@Document
public class BorrowRecord {
    //id
    private String id;
    //借阅的用户
    @DBRef
    private User user;
    //借阅的书籍
    @DBRef
    private Book book;
    //借书时间
    private Date borrowTime;
    //约定还书时间
    private Date appointReturnTime;
    //还书时间
    private Date returnTime;
    //赔付价钱
    private double payMoney;
    //是否还书或赔付
    private Boolean isDeal = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getAppointReturnTime() {
        return appointReturnTime;
    }

    public void setAppointReturnTime(Date appointReturnTime) {
        this.appointReturnTime = appointReturnTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public Boolean getDeal() {
        return isDeal;
    }

    public void setDeal(Boolean deal) {
        isDeal = deal;
    }
}
