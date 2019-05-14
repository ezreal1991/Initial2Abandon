package com.gouqi.entity;

import java.util.List;

/**
 * @ClassName TestCase
 * @Description 接口测试用例
 * @Auther Wangjy
 * @Data 2019/5/13 16:49
 **/
public class TestCase {
    private String name;
    private String caseResult;
    private String level;
    private String belongs;
    // 通过的
    private List<InterfaceBean> passList;
    // 接口请求错误的
    private List<InterfaceBean> errorList;
    // 断言失败的
    private List<InterfaceBean> failList;
    // 超时的
    private List<InterfaceBean> warningList;
    // 所有接口
    private List<InterfaceBean> totalList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public List<InterfaceBean> getPassList() {
        return passList;
    }

    public void setPassList(List<InterfaceBean> passList) {
        this.passList = passList;
    }

    public List<InterfaceBean> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<InterfaceBean> errorList) {
        this.errorList = errorList;
    }

    public List<InterfaceBean> getFailList() {
        return failList;
    }

    public void setFailList(List<InterfaceBean> failList) {
        this.failList = failList;
    }

    public List<InterfaceBean> getWarningList() {
        return warningList;
    }

    public void setWarningList(List<InterfaceBean> warningList) {
        this.warningList = warningList;
    }

    public List<InterfaceBean> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<InterfaceBean> totalList) {
        this.totalList = totalList;
    }
}
