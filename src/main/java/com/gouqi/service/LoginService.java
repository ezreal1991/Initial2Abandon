package com.gouqi.service;

import com.gouqi.entity.UserBean;

public interface LoginService {
    void addUser();
    UserBean searchUserByEmail(UserBean user);
}
