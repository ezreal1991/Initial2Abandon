package com.gouqi.controller;

import com.gouqi.entity.ParamBean;
import com.gouqi.entity.UrlBean;
import com.gouqi.service.RunCaseService;
import com.gouqi.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RunCaseController
 * @Description TODO
 * @Auther Wangjy
 * @Data 2019/5/13 11:35
 **/
@Controller
public class RunCaseController {
    @Autowired
    @Qualifier("runCaseService")
    private RunCaseService runCaseService;
    // 环境变量
    public static Map<String, String> paramMap = new HashMap<>();
    // url
    public static Map<String, UrlBean> urlMap = new HashMap<>();

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 跑测试用例
     * @Date 11:44 2019/5/13
     * @Param []
     **/
    @RequestMapping("/runcase.do")
    public ModelAndView runCase() {
        List<UrlBean> urlBeanList = runCaseService.showAllUrls();
        // 环境变量中的url
        for (UrlBean urlBean : urlBeanList) {
            urlMap.put(urlBean.getName(), urlBean);
        }
        // 环境变量中的参数
        List<ParamBean> paramBeanList = runCaseService.showAllParams();
        for (ParamBean paramBean : paramBeanList) {
            paramMap.put(paramBean.getKey(), paramBean.getValue());
        }
        // 获取真实url
        for (UrlBean url : urlBeanList) {
            UrlUtil.getRealUrl(url);
        }
        return null;
    }
}
