package com.xingui.keer.bean;

import java.io.Serializable;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public class LoginBean implements Serializable {
    private String message;
    private LoginRestlt result;
    private boolean success;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LoginRestlt getResult() {
        return result;
    }
    public void setResult(LoginRestlt result) {
        this.result = result;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

}
