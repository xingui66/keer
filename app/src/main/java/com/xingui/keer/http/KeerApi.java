package com.xingui.keer.http;


import com.xingui.keer.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：
 * ============================================
 */
public interface KeerApi {
    /**
     * String userName = mUserName.getText().toString().trim();
     String password = mPassword.getText().toString().trim();
     if (!checkText(userName) || !checkText(password)) {
     T.showShort(mContext, getString(R.string.login_tip));
     } else {
     OkHttpUtils.get()
     .url(GlobalUrl.UESR_LOGIN_URL)
     .addParams("mobilePhone", userName)
     .addParams("password", password)
     .tag(this)
     .build()
     .execute(mCallback);
     }
     * @return
     */
    @GET("picbook/user/userLogin")
    Observable<LoginBean> login(@Query("mobilePhone") String mobilePhone, @Query("password") String password);
}
