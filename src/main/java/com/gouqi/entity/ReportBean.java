package com.gouqi.entity;

/**
 * @ClassName ReportBean
 * @Description 存放report数据的
 * @Auther Wangjy
 * @Data 2019/5/16 13:19
 **/
public class ReportBean {
    private String name;
    private Integer errorNum;
    private Integer failNum;
    private Integer warningNum;
    private Integer passNum;
    private Integer ierrorNum;
    private Integer ifailNum;
    private Integer iwarningNum;
    private Integer ipassNum;
    private Integer iNum;
    private Integer caseNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public Integer getFailNum() {
        return failNum;
    }

    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    public Integer getWarningNum() {
        return warningNum;
    }

    public void setWarningNum(Integer warningNum) {
        this.warningNum = warningNum;
    }

    public Integer getPassNum() {
        return passNum;
    }

    public void setPassNum(Integer passNum) {
        this.passNum = passNum;
    }

    public Integer getIerrorNum() {
        return ierrorNum;
    }

    public void setIerrorNum(Integer ierrorNum) {
        this.ierrorNum = ierrorNum;
    }

    public Integer getIfailNum() {
        return ifailNum;
    }

    public void setIfailNum(Integer ifailNum) {
        this.ifailNum = ifailNum;
    }

    public Integer getIwarningNum() {
        return iwarningNum;
    }

    public void setIwarningNum(Integer iwarningNum) {
        this.iwarningNum = iwarningNum;
    }

    public Integer getIpassNum() {
        return ipassNum;
    }

    public void setIpassNum(Integer ipassNum) {
        this.ipassNum = ipassNum;
    }

    public Integer getiNum() {
        return iNum;
    }

    public void setiNum(Integer iNum) {
        this.iNum = iNum;
    }

    public Integer getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(Integer caseNum) {
        this.caseNum = caseNum;
    }
}
