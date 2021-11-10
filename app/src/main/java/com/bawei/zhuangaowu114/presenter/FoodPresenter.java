package com.bawei.zhuangaowu114.presenter;

import com.bawei.lib_croe.presenetr.BasePresenter;
import com.bawei.zhuangaowu114.callback.FoodCallBack;
import com.bawei.zhuangaowu114.collter.FoodCollter;
import com.bawei.zhuangaowu114.json.FoodBean;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:40
 *用途：
 */
class FoodPresenter extends BasePresenter<FoodCollter.FoodModel,FoodCollter.FoodView> {

    public FoodPresenter(FoodCollter.FoodModel mModle, FoodCollter.FoodView views) {
        super(mModle, views);
    }

    public void doGET(int page){
        mModle.FoodModels(page, new FoodCallBack() {
            @Override
            public void success(List<FoodBean.DataBean> dataBeans) {
                views.FoodViews(dataBeans);
            }
        });
    }
}
