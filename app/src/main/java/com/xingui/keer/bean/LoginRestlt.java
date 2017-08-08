package com.xingui.keer.bean;

/**
 * =============================================
 * 作者： Lizh on 2017/7/7.
 * 描述：
 * ============================================
 */
public class LoginRestlt {
    private String id;
    private String nickname;
    private String mobilePhone;
    private String password;
    private String sex;
    private String headImgurl;
    private String openId;
    private int isMember;
    private int isWriter;
    private int isReadStar;
    private int isRecordStar;
    private int isOriginalStar;
    private int integral;
    private String createTime;
    private String readTime;
    private String lastLoginTime;
    private String updateTime;
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getHeadImgurl() {
        return headImgurl;
    }
    public void setHeadImgurl(String headImgurl) {
        this.headImgurl = headImgurl;
    }
    public int getIsMember() {
        return isMember;
    }
    public void setIsMember(int isMember) {
        this.isMember = isMember;
    }
    public int getIsWriter() {
        return isWriter;
    }
    public void setIsWriter(int isWriter) {
        this.isWriter = isWriter;
    }
    public int getIsReadStar() {
        return isReadStar;
    }
    public void setIsReadStar(int isReadStar) {
        this.isReadStar = isReadStar;
    }
    public int getIsRecordStar() {
        return isRecordStar;
    }
    public void setIsRecordStar(int isRecordStar) {
        this.isRecordStar = isRecordStar;
    }
    public int getIsOriginalStar() {
        return isOriginalStar;
    }
    public void setIsOriginalStar(int isOriginalStar) {
        this.isOriginalStar = isOriginalStar;
    }
    public int getIntegral() {
        return integral;
    }
    public void setIntegral(int integral) {
        this.integral = integral;
    }
    public String getReadTime() {
        return readTime;
    }
    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
