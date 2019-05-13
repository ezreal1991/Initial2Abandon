package com.gouqi.entity;

/**
 * @ClassName UrlBean
 * @Description url的信息
 * @Auther Wangjy
 * @Data 2019/5/13 13:29
 **/
public class UrlBean {
    private String url;
    private String name;
    private String expectMs;
    private String method;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
