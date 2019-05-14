package com.gouqi.testcase;

import com.gouqi.controller.RunCaseController;
import com.gouqi.entity.InterfaceBean;
import com.gouqi.entity.TestCase;
import com.gouqi.entity.UrlBean;
import com.gouqi.util.HttpClientUtil;
import com.gouqi.util.UrlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CollectionCase
 * @Description 关于收藏部分的接口测试用例
 * @Auther Wangjy
 * @Data 2019/5/13 16:46
 **/
public class CollectionCase {
    public static void run(String name, List<TestCase> restultList){
        TestCase testCase = new TestCase();
        testCase.setName("收藏部分测试用例");
        testCase.setLevel("P3");
        testCase.setBelongs(name);
        testCase.setErrorList(new ArrayList<InterfaceBean>());
        testCase.setFailList(new ArrayList<InterfaceBean>());
        testCase.setPassList(new ArrayList<InterfaceBean>());
        testCase.setWarningList(new ArrayList<InterfaceBean>());
        testCase.setTotalList(new ArrayList<InterfaceBean>());
        UrlBean urlBean1 = RunCaseController.urlMap.get("添加收藏");
        UrlBean urlBean2 = RunCaseController.urlMap.get("单条查询收藏状态");
        UrlBean urlBean3 = RunCaseController.urlMap.get("查询所有收藏");
        UrlBean urlBean4 = RunCaseController.urlMap.get("删除所有收藏");
        InterfaceBean itf1 = UrlUtil.toInterface(urlBean1);
        InterfaceBean itf2 = UrlUtil.toInterface(urlBean2);
        InterfaceBean itf3 = UrlUtil.toInterface(urlBean3);
        InterfaceBean itf4 = UrlUtil.toInterface(urlBean4);

        HttpClientUtil.doGet(itf1);
        HttpClientUtil.doGet(itf2);
        HttpClientUtil.doGet(itf3);
        HttpClientUtil.doGet(itf4);
        UrlUtil.setInfResult(testCase,itf1);
        UrlUtil.setInfResult(testCase,itf2);
//        UrlUtil.setInfResult(testCase,itf3);
//        UrlUtil.setInfResult(testCase,itf4);
        testCase.getTotalList().add(itf1);
        testCase.getTotalList().add(itf2);
        restultList.add(testCase);
    }
}
