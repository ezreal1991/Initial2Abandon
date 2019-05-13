package com.gouqi.entity;

/**
 * @ClassName ParamBean
 * @Description 存放环境变量的Bean
 * @Auther Wangjy
 * @Data 2019/5/13 14:52
 **/
public class ParamBean {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
