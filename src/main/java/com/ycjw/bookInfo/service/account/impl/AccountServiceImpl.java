package com.ycjw.bookInfo.service.account.impl;

import com.ycjw.bookInfo.exception.ExceptionZyc;
import com.ycjw.bookInfo.model.account.User;
import com.ycjw.bookInfo.repository.account.UserDao;
import com.ycjw.bookInfo.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpSession session;
    @Override
    public User login(String account, String password) throws ExceptionZyc {
        verifyAccount(account);
        //验证密码是否符合规范
        if(StringUtils.isEmpty(password)||password.length() < 6){
            //密码不符合规范，抛出异常
            throw ExceptionZyc.PASSWORD_IS_NOT_TRUE;
        }
        //根据账号查询数据库
        User user = userDao.findByAccount(account);
        //判断用户是否存在
        if(user == null){
            //用户不存在，抛出错误
            throw ExceptionZyc.USER_IS_NOT_EXIST;
        }
        //用户存在，判断密码是否相同
        if(!password.equals(user.getPassword())){
            //密码不同，抛出错误
            throw ExceptionZyc.PASSWORD_IS_WRONG;
        }
        //信息符合，执行登录操作,将用户id,角色存入会话中
        session.setAttribute("id",user.getId());
        session.setAttribute("role",user.getRole());
        //返回数据
        return user;
    }

    @Override
    public User register(String account, String fPassword, String sPassword,String name,User.Role role) throws ExceptionZyc {
        verifyAccount(account);
        //验证密码是否符合规范
        if(StringUtils.isEmpty(fPassword)||fPassword.length() < 6){
            //密码不符合规范，抛出异常
            throw ExceptionZyc.PASSWORD_IS_NOT_TRUE;
        }
        //验证两次密码是否相同
        if(!fPassword.equals(sPassword)){
            //两次密码不相同，抛出异常
            throw ExceptionZyc.PASSWORD_IS_NOT_EQUALS;
        }
        //判断用户是否已存在
        if(userDao.findByAccount(account) != null){
            //用户已存在
            throw ExceptionZyc.USER_IS_EXIST;
        }
        //信息符合规范，新建用户
        User user = new User();
        //设置账号
        user.setAccount(account);
        //设置密码
        user.setPassword(fPassword);
        //设置姓名
        user.setName(name);
        //设置角色
        user.setRole(role);
        //保存用户
        userDao.save(user);
        //返回相关信息
        return user;
    }

    /**
     * 验证密码是否符合规范
     * @param account 需要验证的密码
     * @throws ExceptionZyc 可能产生的错误
     */
    void verifyAccount(String account) throws ExceptionZyc{
        //正则表达式格式，表示账号应有字母和数字组成，且6 < LENGTH < 11
        String regex = "^[0-9A-Za-z]{6,11}$";
        //验证账号是否符合规范
        if(!account.matches(regex)){
            //账号不符合规范，抛出异常
            throw ExceptionZyc.USERNAME_IS_NOT_TRUE;
        }
    }
}
