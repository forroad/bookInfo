package com.ycjw.bookInfo.controller;

import com.ycjw.bookInfo.model.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("string")
    public Response getString(){
        return new Response("请求成功","bookInfo");
    }
}
