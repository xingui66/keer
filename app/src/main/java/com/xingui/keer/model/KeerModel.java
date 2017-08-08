package com.xingui.keer.model;

import com.xingui.keer.bean.LoginBean;

import io.reactivex.Observable;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public interface KeerModel {
    interface LoginModel{
        Observable<LoginBean> loginObservable(String mobilePhone,String password);
    }
    interface RegistModel{
        Observable<LoginBean> registObservable(String username);
    }
}
