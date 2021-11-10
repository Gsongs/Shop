package com.bawei.zhuangaowu114.api;

import com.bawei.zhuangaowu114.json.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:32
 *用途：
 */
interface Api {

    @GET("dish_list.php?stage_id=1&limit=40&")
    Observable<FoodBean> getData(@Query("page") int page);
}
