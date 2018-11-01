package com.ycjw.bookInfo.controller.account;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.account.User;
import com.ycjw.bookInfo.model.response.Response;
import com.ycjw.bookInfo.service.account.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ApiOperation("登录")
    @PostMapping("login")
    public Response login(@RequestParam("account") String account,
                          @RequestParam("password") String password) throws ExceptionZyc {
        return new Response("登录成功",accountService.login(account,password));
    }
    @ApiOperation("注册")
    @PutMapping("register")
    public Response register(@RequestParam("account") String account,
                             @RequestParam("fPassword") String fPassword,
                             @RequestParam("sPassword") String sPassword,
                             @RequestParam("name") String name,
                             @RequestParam("role")User.Role role) throws ExceptionZyc {
        return new Response("注册成功",accountService.register(account,fPassword,sPassword,name,role));
    }

}
