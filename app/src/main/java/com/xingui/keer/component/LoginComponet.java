package com.xingui.keer.component;

import com.xingui.keer.module.LoginModule;
import com.xingui.keer.ui.MainActivity;

import dagger.Component;

/**
 * =============================================
 * 作者： Lizh on 2017/8/8.
 * 描述： 建立一个Acivity和module之间的关系
 * ============================================
 */
@Component(modules = LoginModule.class)
public interface LoginComponet {
    void inject(MainActivity activity);
}
