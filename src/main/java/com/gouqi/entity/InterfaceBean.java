package com.gouqi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName InterfaceBean
 * @Description 接口的测试结果存放
 * @Auther Wangjy
 * @Data 2019/5/14 9:31
 **/
public class InterfaceBean {
    private String url;
    private String name;
    private String expectMs;
    private String actualMs;
    private String method;
    private String interfaceResult;
    private String startTime;
    private JSONObject jsonResult;
    private String msg;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpectMs() {
        return expectMs;
    }

    public void setExpectMs(String expectMs) {
        this.expectMs = expectMs;
    }

    public String getActualMs() {
        return actualMs;
    }

    public void setActualMs(String actualMs) {
        this.actualMs = actualMs;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getInterfaceResult() {
        return interfaceResult;
    }

    public void setInterfaceResult(String interfaceResult) {
        this.interfaceResult = interfaceResult;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public JSONObject getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(JSONObject jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
