package com.xingui.keer.model;

import com.xingui.keer.bean.LoginBean;
import com.xingui.keer.http.KeerApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述： 返回一个接口，传递返回的对象
 * ============================================
 */
public class KeerModelImpl implements KeerModel.LoginModel {
    @Override
    public Observable<LoginBean> loginObservable(String mobilePhone,String password) {
        return KeerApiService.getKeerApi()
                .login(mobilePhone,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
