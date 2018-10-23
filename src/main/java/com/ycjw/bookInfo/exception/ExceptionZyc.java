package com.ycjw.bookInfo.exception;

import com.ycjw.bookInfo.model.response.Response;

public class ExceptionZyc extends Exception {
    private Response response;

    public ExceptionZyc() {
    }

    public ExceptionZyc(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
