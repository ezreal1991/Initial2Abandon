package com.gouqi.service;

import com.gouqi.dao.UserDao;
import com.gouqi.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ ClassName LoginServiceImpl
 * @ Description LoginService的实现类
 * @ Author wangjy
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {

    }

    @Override
    public UserBean searchUserByEmail(UserBean user) {
        return  userDao.selectUser(user);
    }
}
