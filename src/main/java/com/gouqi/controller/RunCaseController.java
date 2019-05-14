package com.gouqi.controller;

import com.gouqi.entity.ParamBean;
import com.gouqi.entity.TestCase;
import com.gouqi.entity.UrlBean;
import com.gouqi.service.RunCaseService;
import com.gouqi.testcase.CollectionCase;
import com.gouqi.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        List<TestCase> resultList = new ArrayList<TestCase>();
        CollectionCase.run("第一个testcase", resultList);
        int errorNum = 0;
        int failNum = 0;
        int warningNum = 0;
        int passNum = 0;
        int ierrorNum = 0;
        int ifailNum = 0;
        int iwarningNum = 0;
        int ipassNum = 0;
        int iNum = 0;
        for(TestCase testcase:resultList){
            if(testcase.getErrorList().size()>0){
                testcase.setCaseResult("error");
                errorNum ++;
            } else if(testcase.getFailList().size() > 0){
                testcase.setCaseResult("fail");
                failNum ++;
            }	else if(testcase.getWarningList().size() > 0){
                testcase.setCaseResult("warning");
                warningNum ++;
            } else{
                testcase.setCaseResult("pass");
                passNum ++;
            }
            ierrorNum += testcase.getErrorList().size();
            ifailNum += testcase.getFailList().size();
            iwarningNum += testcase.getWarningList().size();
            ipassNum += testcase.getPassList().size();
            iNum += testcase.getTotalList().size();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorNum", errorNum);
        modelAndView.addObject("failNum", failNum);
        modelAndView.addObject("warningNum", warningNum);
        modelAndView.addObject("passNum", passNum);
        modelAndView.addObject("ierrorNum", ierrorNum);
        modelAndView.addObject("ifailNum", ifailNum);
        modelAndView.addObject("iwarningNum", iwarningNum);
        modelAndView.addObject("ipassNum", ipassNum);
        modelAndView.addObject("iNum", iNum);
        modelAndView.addObject("caseNum", resultList.size());
        modelAndView.addObject("resultList", resultList);
        modelAndView.setViewName("/WEB-INF/jsp/report.jsp");
        return modelAndView;
    }
}
