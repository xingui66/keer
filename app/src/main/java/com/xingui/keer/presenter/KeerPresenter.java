package com.xingui.keer.presenter;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public interface KeerPresenter {
    interface LoginPresenter{
        void login(String mobilePhone,String password);
    }
    interface RegistPresenter{
        void registPresenter(String username);
    }
}
