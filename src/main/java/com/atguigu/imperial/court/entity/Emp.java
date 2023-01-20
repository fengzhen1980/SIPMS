package com.atguigu.imperial.court.entity;

public class Emp {

    private Integer empId;
    private String empName;
    private String empPosition;
    private String loginAccount;
    private String loginPassword;

    public Emp() {
    }

    public Emp(Integer empId, String empName, String empPosition, String loginAccount, String loginPassword) {
        this.empId = empId;
        this.empName = empName;
        this.empPosition = empPosition;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
