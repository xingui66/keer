package com.xingui.keer.view;

import com.xingui.keer.bean.LoginBean;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public interface KeerView {
    interface LoginView extends BaseView{
        void shouLoginSuccess(LoginBean loginBean);
    }
}
