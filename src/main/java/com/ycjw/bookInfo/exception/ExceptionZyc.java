package com.ycjw.bookInfo.exception;

import com.ycjw.bookInfo.model.response.Response;

public class ExceptionZyc extends Exception {
    public static final ExceptionZyc SERVER_ERROR = new ExceptionZyc(new Response(null, "未知错误"));
    public static final ExceptionZyc USERNAME_IS_NOT_TRUE = new ExceptionZyc(new Response(null, "用户名格式不正确"));
    public static final ExceptionZyc PASSWORD_IS_NOT_TRUE = new ExceptionZyc(new Response(null, "密码格式不正确"));
    public static final ExceptionZyc PASSWORD_IS_NOT_EQUALS = new ExceptionZyc(new Response(null, "两次密码不相同"));
    public static final ExceptionZyc PASSWORD_IS_WRONG = new ExceptionZyc(new Response(null, "密码错误"));
    public static final ExceptionZyc USER_IS_NOT_EXIST = new ExceptionZyc(new Response(null, "用户不存在"));
    public static final ExceptionZyc USER_IS_EXIST = new ExceptionZyc(new Response(null, "用户已存在"));
    public static final ExceptionZyc PARAM_IS_NULL = new ExceptionZyc(new Response(null, "参数不能为空"));
    public static final ExceptionZyc BOOK_IS_NOT_EXIST = new ExceptionZyc(new Response(null, "书籍不存在"));
    public static final ExceptionZyc BOOK_IS_NOT_IN = new ExceptionZyc(new Response(null, "书籍不在馆"));
    public static final ExceptionZyc USER_IS_NOT_BORROW_THIS_BOOK = new ExceptionZyc(new Response(null, "该书籍尚未被该用户借阅"));
    public static final ExceptionZyc PAYMONEY_IS_LITTLE = new ExceptionZyc(new Response(null, "赔付金额太少"));
    private Response response;

    public ExceptionZyc() {
    }

    public ExceptionZyc(Response response) {
        this.response = response;
        this.response.setMessage("error");
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
