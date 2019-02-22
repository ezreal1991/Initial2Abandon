package com.gouqi.dao;

import com.gouqi.entity.UserBean;

public interface UserDao {

    UserBean selectUser(UserBean user);
}
