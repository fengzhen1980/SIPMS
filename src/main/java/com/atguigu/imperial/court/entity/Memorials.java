package com.atguigu.imperial.court.entity;

public class Memorials {

    private Integer memorialsId;
    private String memorialsTitle;
    private String memorialsContent;

    //奏折的摘要数据库里没有，这里是为了配合页面的显示
    private String memorialsContentDigest;
    private Integer memorialsEmp;

    //员工姓名数据库里没有，这里是为了配合页面的显示
    private String memorialsEmpName;
    private String memorialsCreateTime;
    private String feedbackTime;
    private String feedbackContent;
    private Integer memorialsStatus;

    public Memorials() {
    }

    public Memorials(Integer memorialsId, String memorialsTitle, String memorialsContent, String memorialsContentDigest, Integer memorialsEmp, String memorialsEmpName, String memorialsCreateTime, String feedbackTime, String feedbackContent, Integer memorialsStatus) {
        this.memorialsId = memorialsId;
        this.memorialsTitle = memorialsTitle;
        this.memorialsContent = memorialsContent;
        this.memorialsContentDigest = memorialsContentDigest;
        this.memorialsEmp = memorialsEmp;
        this.memorialsEmpName = memorialsEmpName;
        this.memorialsCreateTime = memorialsCreateTime;
        this.feedbackTime = feedbackTime;
        this.feedbackContent = feedbackContent;
        this.memorialsStatus = memorialsStatus;
    }

    @Override
    public String toString() {
        return "memorials{" +
                "memorialsId=" + memorialsId +
                ", memorialsTitle='" + memorialsTitle + '\'' +
                ", memorialsContent='" + memorialsContent + '\'' +
                ", memorialsContentDigest='" + memorialsContentDigest + '\'' +
                ", memorialsEmp=" + memorialsEmp +
                ", memorialsEmpName='" + memorialsEmpName + '\'' +
                ", memorialsCreateTime='" + memorialsCreateTime + '\'' +
                ", feedbackTime='" + feedbackTime + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", memorialsStatus=" + memorialsStatus +
                '}';
    }

    public Integer getMemorialsId() {
        return memorialsId;
    }

    public String getMemorialsTitle() {
        return memorialsTitle;
    }

    public String getMemorialsContent() {
        return memorialsContent;
    }

    public String getMemorialsContentDigest() {
        return memorialsContentDigest;
    }

    public Integer getMemorialsEmp() {
        return memorialsEmp;
    }

    public String getMemorialsEmpName() {
        return memorialsEmpName;
    }

    public String getMemorialsCreateTime() {
        return memorialsCreateTime;
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public Integer getMemorialsStatus() {
        return memorialsStatus;
    }

    public void setMemorialsId(Integer memorialsId) {
        this.memorialsId = memorialsId;
    }

    public void setMemorialsTitle(String memorialsTitle) {
        this.memorialsTitle = memorialsTitle;
    }

    public void setMemorialsContent(String memorialsContent) {
        this.memorialsContent = memorialsContent;
    }

    public void setMemorialsContentDigest(String memorialsContentDigest) {
        this.memorialsContentDigest = memorialsContentDigest;
    }

    public void setMemorialsEmp(Integer memorialsEmp) {
        this.memorialsEmp = memorialsEmp;
    }

    public void setMemorialsEmpName(String memorialsEmpName) {
        this.memorialsEmpName = memorialsEmpName;
    }

    public void setMemorialsCreateTime(String memorialsCreateTime) {
        this.memorialsCreateTime = memorialsCreateTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public void setMemorialsStatus(Integer memorialsStatus) {
        this.memorialsStatus = memorialsStatus;
    }
}
