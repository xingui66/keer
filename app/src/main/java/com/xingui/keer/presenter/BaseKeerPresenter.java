package com.xingui.keer.presenter;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public class BaseKeerPresenter<T> {
    T view ;
    public BaseKeerPresenter(T view){
        this.view=view;
    };
}
