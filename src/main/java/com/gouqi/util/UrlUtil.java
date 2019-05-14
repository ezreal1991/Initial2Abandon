package com.gouqi.util;

import com.gouqi.entity.InterfaceBean;
import com.gouqi.entity.TestCase;
import com.gouqi.entity.UrlBean;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.gouqi.controller.RunCaseController.paramMap;

/**
 * @ClassName UrlUtil
 * @Description 关于Url的参数化
 * @Auther Wangjy
 * @Data 2019/5/13 14:30
 **/
public class UrlUtil {
    /**
     * @return java.util.List<java.lang.String>
     * @Description 取出参数部分
     * @Date 14:31 2019/5/13
     * @Param [reg, str]
     **/
    public static List<String> find(String str) {
        Matcher matcher = Pattern.compile("(?<=(?<!\\\\)\\$\\{)(.*?)(?=(?<!\\\\)\\})").matcher(str);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /**
     * @return void
     * @Description 获取真实URL
     * @Date 16:26 2019/5/13
     * @Param [url]
     **/
    public static void getRealUrl(UrlBean url) {
        List<String> UrlParamList = UrlUtil.find(url.getUrl());
        if (UrlParamList.size() > 0) {
            for (String param : UrlParamList) {
                String value = paramMap.get(param.trim());
                String paramStr = "${" + param + "}";
                String url2 = url.getUrl().replace(paramStr, value);
                url.setUrl(url2);
            }
        }
    }

    /**
     * @Description // 将urlBean转化成interfaceBean
     * @Date 10:35 2019/5/14
     * @Param [urlBean]
     * @return com.gouqi.entity.InterfaceBean
     **/
    public static InterfaceBean toInterface(UrlBean urlBean) {
        InterfaceBean interfaceBean = new InterfaceBean();
        interfaceBean.setName(urlBean.getName());
        interfaceBean.setUrl(urlBean.getUrl());
        interfaceBean.setExpectMs(urlBean.getExpectMs());
        interfaceBean.setMethod(urlBean.getMethod());
        return interfaceBean;
    }

    public static void setInfResult(TestCase testCase, InterfaceBean itf){
        if (itf.getActualMs() == null) {
            testCase.getErrorList().add(itf);
            itf.setInterfaceResult("error");
        } else {
            if (itf.getJsonResult() != null) {
                String code = itf.getJsonResult().getString("code");
                // 断言
                if (!"1".equals(code)) {
                    testCase.getFailList().add(itf);
                    itf.setInterfaceResult("fail");
                } else {
                    // 超时
                    if (Long.parseLong(itf.getActualMs()) > Long.parseLong(itf.getExpectMs())) {
                        testCase.getWarningList().add(itf);
                        itf.setInterfaceResult("warning");
                    } else {
                        testCase.getPassList().add(itf);
                        itf.setInterfaceResult("pass");
                    }
                }
            }
        }
    }
}
