package com.bawei.zhuangaowu114.model;

import com.bawei.lib_croe.model.BaseModel;
import com.bawei.zhuangaowu114.api.Api;
import com.bawei.zhuangaowu114.callback.FoodCallBack;
import com.bawei.zhuangaowu114.collter.FoodCollter;
import com.bawei.zhuangaowu114.http.HttpManager;
import com.bawei.zhuangaowu114.json.FoodBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:38
 *用途：
 */
class FoodModel extends BaseModel implements FoodCollter.FoodModel {
    @Override
    public void FoodModels(int page, FoodCallBack callBack) {
        HttpManager.getInstance().getManager("https://www.qubaobei.com/ios/cf/")
                .create(Api.class)
                .getData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull FoodBean foodBean) {
                        List<FoodBean.DataBean> data = foodBean.getData();

                        callBack.success(data);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
