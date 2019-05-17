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
    public static void run(String name, List<TestCase> restultList) {
        TestCase testCase = new TestCase();
        testCase.setName("收藏部分测试用例");
        testCase.setLevel("P3");
        testCase.setBelongs(name);
        testCase.setErrorList(new ArrayList<InterfaceBean>());
        testCase.setFailList(new ArrayList<InterfaceBean>());
        testCase.setPassList(new ArrayList<InterfaceBean>());
        testCase.setWarningList(new ArrayList<InterfaceBean>());
        testCase.setTotalList(new ArrayList<InterfaceBean>());
        // url信息
        UrlBean urlBean1 = RunCaseController.urlMap.get("添加收藏");
        UrlBean urlBean2 = RunCaseController.urlMap.get("单条查询收藏状态");
        UrlBean urlBean3 = RunCaseController.urlMap.get("查询所有收藏");
        UrlBean urlBean4 = RunCaseController.urlMap.get("删除所有收藏");
        if (urlBean1 != null) {
            // 转化为接口结果
            InterfaceBean itf1 = UrlUtil.toInterface(urlBean1);
            // 执行
            HttpClientUtil.doGet(itf1);
            UrlUtil.setInfResult(testCase, itf1);
            testCase.getTotalList().add(itf1);
        }
        if (urlBean2 != null) {
            InterfaceBean itf2 = UrlUtil.toInterface(urlBean2);
            HttpClientUtil.doGet(itf2);
            UrlUtil.setInfResult(testCase, itf2);
            testCase.getTotalList().add(itf2);
        }
        if (urlBean3 != null) {
            InterfaceBean itf3 = UrlUtil.toInterface(urlBean3);
            HttpClientUtil.doGet(itf3);
            UrlUtil.setInfResult(testCase, itf3);
            // 增加断言
            if (itf3.getInterfaceResult().equals("pass")) {
                String resultName = null;
                try {
                    resultName = itf3.getJsonResult().getJSONArray("data").getJSONObject(0).getString("name");
                    if (!"营养健康省钱菜".equals(resultName)) {
                        itf3.setInterfaceResult("fail");
                        itf3.setMsg("name 预想结果： 营养健康省钱菜；实际结果：" + resultName);
                        testCase.getPassList().remove(itf3);
                        testCase.getFailList().add(itf3);
                    }
                } catch (IndexOutOfBoundsException e) {
                    itf3.setInterfaceResult("fail");
                    itf3.setMsg("name 预想结果：营养健康省钱菜；实际结果：查无此值");
                    testCase.getPassList().remove(itf3);
                    testCase.getFailList().add(itf3);
                }

            }
            if (itf3.getInterfaceResult().equals("warning")) {
                String resultName = null;
                try {
                    resultName = itf3.getJsonResult().getJSONArray("data").getJSONObject(0).getString("name");
                    if (!"营养健康省钱菜".equals(resultName)) {
                        itf3.setInterfaceResult("fail");
                        itf3.setMsg("name 预想结果： 营养健康省钱菜；实际结果：" + resultName);
                        testCase.getWarningList().remove(itf3);
                        testCase.getFailList().add(itf3);
                    }
                }catch (IndexOutOfBoundsException e){
                    itf3.setInterfaceResult("fail");
                    itf3.setMsg("name 预想结果： 营养健康省钱菜；实际结果：查无此值");
                    testCase.getWarningList().remove(itf3);
                    testCase.getFailList().add(itf3);
                }

            }
            testCase.getTotalList().add(itf3);
        }
        if (urlBean4 != null) {
            InterfaceBean itf4 = UrlUtil.toInterface(urlBean4);
            HttpClientUtil.doGet(itf4);
            UrlUtil.setInfResult(testCase, itf4);
            testCase.getTotalList().add(itf4);
        }
        restultList.add(testCase);
    }
}
