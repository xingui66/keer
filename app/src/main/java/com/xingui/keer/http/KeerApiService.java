package com.xingui.keer.http;

import com.xingui.keer.global.Constant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * =============================================
 * 作者： Lizh on 2017/7/5.
 * 描述：返回一个api
 * ============================================
 */
public class KeerApiService {
    public static KeerApi getKeerApi(){
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .build())
                .baseUrl(Constant.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(KeerApi.class);
    }
}
