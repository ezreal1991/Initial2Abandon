package com.gouqi.util;

import com.gouqi.entity.InterfaceBean;
import com.gouqi.entity.ReportBean;
import com.gouqi.entity.TestCase;

import java.io.*;
import java.util.List;

/**
 * @ClassName ReportUtil
 * @Description 存储report的工具类
 * @Auther Wangjy
 * @Data 2019/5/16 13:21
 **/
public class ReportUtil {
    private final static String htmlPath = "D:\\html\\";
    public static void storeRecord(ReportBean rpf, List<TestCase> resultList){
        FileOutputStream fileOutputStream = null;
        BufferedWriter out = null;
        String content = "";
        String folderPath = TimeUtil.getTime("yyyy-MM-dd");
        File folder = new File(htmlPath + folderPath);
        File html = new File(htmlPath + folderPath + "\\" + rpf.getName() + ".html");
        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!html.exists()) {
                html.createNewFile();
            }
            fileOutputStream = new FileOutputStream(html);
            out = new BufferedWriter(new OutputStreamWriter(fileOutputStream,"utf-8"));
            content += "<!DOCTYPE html>";
            content += "<html>";
            content += "<head>";
            content += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
            content += "<title>Title</title>";
            content += "<link rel='stylesheet' href='https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css'>";
            content += "<script src='https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js'></script>";
            content += "<script src='https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>";
            content += "</head>";
            content += "<body>";
            content += "<div class='container'>";
            content += "<h2>测试结果</h2>";
            content += "<table class='table table-striped table-condensed table-bordered'>";
            content += "<thead><tr>";
            content += "<th>#</th><th>测试用例</th><th>接口</th>";
            content += "</tr></thead>";
            content += "<tbody><tr>";
            content += "<td>pass</td><td>" + rpf.getPassNum();
            content += "</td><td>" + rpf.getIpassNum() + "</td></tr>";
            content += "<tr><td>warning</td><td>" + rpf.getWarningNum();
            content += "</td><td>" + rpf.getIwarningNum() + "</td></tr>";
            content += "<tr><td>fail</td><td>" + rpf.getFailNum();
            content += "</td><td>" + rpf.getIfailNum() + "</td></tr>";
            content += "<tr><td>error</td><td>" + rpf.getErrorNum();
            content += "</td><td>" + rpf.getIerrorNum() + "</td></tr>";
            content += "<tr><td>total</td><td>" + rpf.getCaseNum();
            content += "</td><td>" + rpf.getiNum() + "</td></tr>";
            content += "</table>";
            content += "<div style=\"float: left;width: 30%\">";
            content += "<h3>TestCase</h3>";
            content += "<table class=\"table table-condensed table-bordered\">";
            content += "<tr><td>name</td><td>level</td><td>result</td></tr>";
            for(TestCase testCase : resultList){
                if("error".equals(testCase.getCaseResult())){
                    content += "<tr><td><a class=\"text-danger\" href=\"javascript:void(0)\" onclick=\"showDetail('";
                    content += testCase.getName() + "')\">" + testCase.getName() + "</a></td>";
                    content += "<td><span class=\"text-danger\">" + testCase.getLevel() + "</span></td>";
                    content += "<td><span class=\"text-danger\">error</span></td></tr>";
                }
            }
            for(TestCase testCase : resultList){
                if("fail".equals(testCase.getCaseResult())){
                    content += "<tr><td><a class=\"text-danger\" href=\"javascript:void(0)\" onclick=\"showDetail('";
                    content += testCase.getName() + "')\">" + testCase.getName() + "</a></td>";
                    content += "<td><span class=\"text-danger\">" + testCase.getLevel() + "</span></td>";
                    content += "<td><span class=\"text-danger\">fail</span></td></tr>";
                }
            }
            for(TestCase testCase : resultList){
                if("warning".equals(testCase.getCaseResult())){
                    content += "<tr><td><a span class=\"text-warning\" href=\"javascript:void(0)\" onclick=\"showDetail('";
                    content += testCase.getName() + "')\">" + testCase.getName() + "</a></td>";
                    content += "<td><span class=\"text-warning\">" + testCase.getLevel() + "</span></td>";
                    content += "<td><span class=\"text-warning\">warning</span></td></tr>";
                }
            }
            for(TestCase testCase : resultList){
                if("pass".equals(testCase.getCaseResult())){
                    content += "<tr><td><a class=\"text-success\" href=\"javascript:void(0)\" onclick=\"showDetail('";
                    content += testCase.getName() + "')\">" + testCase.getName() + "</a></td>";
                    content += "<td><span class=\"text-success\">" + testCase.getLevel() + "</span></td>";
                    content += "<td><span class=\"text-success\">pass</span></td></tr>";
                }
            }
            content += "</table>";
            content += "</div>";
            content += "<div style=\"float: right;width: 60%;word-wrap:break-word\">";
            content += "<h3>Detail</h3>";
            for(TestCase testCase : resultList){
                content += "<div id=\"" + testCase.getName() + "\" name=\"detail\">";
                if("error".equals(testCase.getCaseResult())){
                    content += "<span class=\"text-danger\">" + testCase.getName() + "</span>";
                }
                if("fail".equals(testCase.getCaseResult())){
                    content += "<span class=\"text-danger\">" + testCase.getName() + "</span>";
                }
                if("warning".equals(testCase.getCaseResult())){
                    content += "<span class=\"text-warning\">" + testCase.getName() + "</span>";
                }
                if("pass".equals(testCase.getCaseResult())){
                    content += "<span class=\"text-success\">" + testCase.getName() + "</span>";
                }
                content += "<br /><br />";
                for(InterfaceBean interfaceBean: testCase.getTotalList()){
                    if("error".equals(interfaceBean.getInterfaceResult())){
                        content += "<span class=\"text-danger\">" + interfaceBean.getName() + "</span>";
                        content += "<span style=\"margin-left:20px\" class=\"text-danger\">" + "error" + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getStartTime() + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getActualMs() + "Ms</span><br />";
                        content += "url:<pre>" + interfaceBean.getUrl() + "</pre>";
                        content += "返回值:<pre>" + interfaceBean.getJsonResult()+ "</pre><br />";
                    }
                    if("fail".equals(interfaceBean.getInterfaceResult())){
                        content += "<span class=\"text-danger\">" + interfaceBean.getName() + "</span>";
                        content += "<span style=\"margin-left:20px\" class=\"text-danger\">" + "fail" + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getStartTime() + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getActualMs() + "Ms</span><br />";
                        content += "url:<pre>" + interfaceBean.getUrl() + "</pre>";
                        content += "返回值:<pre>" + interfaceBean.getJsonResult()+ "</pre><br />";
                        content += "<span class=\"text-danger\">" + interfaceBean.getMsg() + "</span><br /><br />";
                    }
                    if("warning".equals(interfaceBean.getInterfaceResult())){
                        content += "<span class=\"text-warning\">" + interfaceBean.getName() + "</span>";
                        content += "<span style=\"margin-left:20px\" class=\"text-warning\">" + "warning" + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getStartTime() + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getActualMs() + "Ms</span><br />";
                        content += "url:<pre>" + interfaceBean.getUrl() + "</pre>";
                        content += "返回值:<pre>" + interfaceBean.getJsonResult()+ "</pre><br />";
                    }
                    if("pass".equals(interfaceBean.getInterfaceResult())){
                        content += "<span class=\"text-success\">" + interfaceBean.getName() + "</span>";
                        content += "<span style=\"margin-left:20px\" class=\"text-success\">" + "pass" + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getStartTime() + "</span>";
                        content += "<span style=\"margin-left:20px\">" + interfaceBean.getActualMs() + "Ms</span><br />";
                        content += "url:<pre>" + interfaceBean.getUrl() + "</pre>";
                        content += "返回值:<pre>" + interfaceBean.getJsonResult()+ "</pre><br />";
                    }
                }
                content += "</div>";
            }
            content += "</div>";
            content += "</div>";
            content += "</body>\r\n";
            content += "<script>\r\n";
            content += "window.onload = function () {\r\n";
            content += "var divs = document.getElementsByName(\"detail\");\r\n";
            content += "for (var i = 1; i < divs.length; i++) {\r\n";
            content += " divs[i].style.display = \"none\";}\r\n}\r\n";
            content += "function showDetail(name) {\r\n";
            content += "var divs = document.getElementsByName(\"detail\");\r\n";
            content += "for (var i = 0; i < divs.length; i++) {\r\n";
            content += "divs[i].style.display = \"none\";}\r\n";
            content += "document.getElementById(name).style.display = \"\";}\r\n";
            content += "</script>";
            content += "</html>";
            out.write(content);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
