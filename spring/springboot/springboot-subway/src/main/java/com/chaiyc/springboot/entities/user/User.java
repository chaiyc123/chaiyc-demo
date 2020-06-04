package com.chaiyc.springboot.entities.user;

import java.io.Serializable;

/**
 * 用户信息实体类
 */
public class User implements Serializable {
    private String userAcctId;         //账号id
    private String userName;		  //人员姓名
    private String userSex;           //性别 1男 2女
    private String userBirthday;      //出生日期 1985-05-12
    private String userIdentityCode;  //身份证号
    private String userAddress;       //家庭住址
    private String userTele;		  //联系电话
    private String userEmail;		  //邮箱
    private String loginAccount;	  //登录账号
    private String loginPassword;     //登录密码
    private String userState;             //状态 0停用 1启用
    private String createTime;        //创建时间 2014-06-15 12:23:55

    public String getUserAcctId() {
        return userAcctId;
    }

    public void setUserAcctId(String userAcctId) {
        this.userAcctId = userAcctId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserIdentityCode() {
        return userIdentityCode;
    }

    public void setUserIdentityCode(String userIdentityCode) {
        this.userIdentityCode = userIdentityCode;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserTele() {
        return userTele;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
