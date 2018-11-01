package com.ycjw.bookInfo.service.account;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.account.User;


//账号相关操作
public interface AccountService {
    /**
    *登录
    *@param  account 账号
    *@param  password 密码
    *@return 登录成功用户相关信息
     */
    User login(String account,String password) throws ExceptionZyc;
    /**
    *注册
    *@param account 账号
     * @param fPassword 密码
     * @param sPassword 验证密码
     * @return 注册成功返回用户相关信息
     */
    User register(String account, String fPassword, String sPassword, String name, User.Role role) throws ExceptionZyc;
}
