package com.xingui.keer.module;

import com.xingui.keer.presenter.LoginPresenter;
import com.xingui.keer.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * =============================================
 * 作者： Lizh on 2017/8/8.
 * 描述： 用来new Presenter对象的，把原先activity里的代码挪过来
 * 步骤： 1.新建class类
 *        2.指定module类，类上写@Module
 *        3.传入activity的构造
 *        4.指定module方法，用来new对象并返回，@Provides
 * ============================================
 */
@Module
public class LoginModule {
    MainActivity mainActivity;
    public LoginModule(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }
    @Provides
    LoginPresenter provideLoginPresenter(){
        return new LoginPresenter(mainActivity);
    }

}
