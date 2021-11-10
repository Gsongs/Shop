package com.bawei.zhuangaowu114.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:36
 *用途：网络单例
 */
class HttpManager{
    private volatile static HttpManager manager;
    public static HttpManager getInstance(){
        if (manager==null){
            synchronized (HttpManager.class){
                manager = new HttpManager();
            }
        }
        return manager;
    }

    public Retrofit getManager(String url){
        return new Retrofit.Builder().baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()).build();
    }
}
