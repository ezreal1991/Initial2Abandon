package com.gouqi.controller;

import com.gouqi.entity.UserBean;
import com.gouqi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ ClassName LoginController
 * @ Description 完成登录验证
 * @ Author wangjy
 **/
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login.do")
    public ModelAndView doLogin(UserBean user) {
        UserBean userBean = loginService.searchUserByEmail(user);
        ModelAndView modelAndView = new ModelAndView();
        if (userBean == null) {
            modelAndView.addObject("msg", "邮箱或密码错误");
            modelAndView.setViewName("/login.jsp");
        } else {
            modelAndView.addObject("user", userBean);
            modelAndView.setViewName("/WEB-INF/jsp/main.jsp");
        }
        return modelAndView;
    }
}
