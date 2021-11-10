package com.bawei.zhuangaowu114.collter;

import com.bawei.lib_croe.model.IModel;
import com.bawei.lib_croe.view.IView;
import com.bawei.zhuangaowu114.callback.FoodCallBack;
import com.bawei.zhuangaowu114.json.FoodBean;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:34
 *用途：
 */
interface FoodCollter {
    interface FoodModel extends IModel{
        void FoodModels(int page, FoodCallBack callBack);
    }
    interface FoodView extends IView{
        void FoodViews(List<FoodBean.DataBean> dataBeans);
    }
}

