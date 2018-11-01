package com.ycjw.bookInfo.exception;

import com.ycjw.bookInfo.model.response.Response;

public class ExceptionZyc extends Exception {
    public static final ExceptionZyc USERNAME_IS_NOT_TRUE = new ExceptionZyc(new Response(null, "用户名格式不正确"));
    public static final ExceptionZyc PASSWORD_IS_NOT_TRUE = new ExceptionZyc(new Response(null, "密码格式不正确"));
    public static final ExceptionZyc PASSWORD_IS_NOT_EQUALS = new ExceptionZyc(new Response(null, "两次密码不相同"));
    public static final ExceptionZyc PASSWORD_IS_WRONG = new ExceptionZyc(new Response(null, "密码错误"));
    public static final ExceptionZyc USER_IS_NOT_EXIST = new ExceptionZyc(new Response(null, "用户不存在"));
    public static final ExceptionZyc USER_IS_EXIST = new ExceptionZyc(new Response(null, "用户已存在"));
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
