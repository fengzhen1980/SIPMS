package com.atguigu.imperial.court.entity;


public class TUser {

    private String userId;
    private String userPassword;
    private String userCategory;
    private String userFirstName;
    private String userLastName;
    private Integer userAge;
    private String userGender;
    private String userEmail;
    private String userAddress;

    public TUser() {
    }

    public TUser(String userId, String userPassword, String userCategory, String userFirstName, String userLastName,
                 Integer userAge, String userGender, String userEmail, String userAddress) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userCategory = userCategory;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userId=" + userId +
                ", userPassword=" + userPassword +
                ", userCategory=" + userCategory +
                ", userFirstName=" + userFirstName +
                ", userLastName=" + userLastName +
                ", userAge=" + userAge +
                ", userGender=" + userGender +
                ", userEmail=" + userEmail +
                ", userAddress=" + userAddress + "}";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }


    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }


    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public long getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }


    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}
