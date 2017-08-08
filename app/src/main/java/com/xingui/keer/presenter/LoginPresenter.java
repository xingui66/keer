package com.xingui.keer.presenter;

import com.xingui.keer.bean.LoginBean;
import com.xingui.keer.model.KeerModel;
import com.xingui.keer.model.KeerModelImpl;
import com.xingui.keer.view.KeerView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public class LoginPresenter extends BaseKeerPresenter<KeerView.LoginView> implements KeerPresenter.LoginPresenter {
    KeerModel.LoginModel loginModel;

    public LoginPresenter(KeerView.LoginView view) {
        super(view);
        loginModel=new KeerModelImpl();
    }

    @Override
    public void login(String mobilePhone,String password) {
        loginModel.loginObservable(mobilePhone,password).subscribe(new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean value) {
                view.shouLoginSuccess(value);
            }

            @Override
            public void onError(Throwable e) {
                view.netError();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
