package com.bawei.zhuangaowu114.fragmentss;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.lib_croe.user.Users;
import com.bawei.lib_croe.view.BaseFragment;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.collter.FoodCollter;
import com.bawei.zhuangaowu114.http.UserManager;
import com.bawei.zhuangaowu114.json.FoodBean;
import com.bawei.zhuangaowu114.model.FoodModel;
import com.bawei.zhuangaowu114.mydapater.Food_Dapater;
import com.bawei.zhuangaowu114.presenter.FoodPresenter;
import com.bawie.lib_croe.db.UsersDao;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:16
 *用途：轮播图和数据
 */
class Vtab_one extends BaseFragment implements FoodCollter.FoodView, OnRefreshLoadMoreListener {
    private Banner banners;
    private SmartRefreshLayout smar;
    private RecyclerView res;
    private int page = 3;
    private boolean iRse = true;
    FoodPresenter foodPresenter;
    Food_Dapater dapater;
    @Override
    public int bandLayout() {
        return R.layout.vtab_one;
    }

    @Override
    public void initView() {

        banners = (Banner) findViewById(R.id.banners);
        smar = (SmartRefreshLayout) findViewById(R.id.smar);
        res = (RecyclerView) findViewById(R.id.res);
        smar.setOnRefreshLoadMoreListener(this);
        res.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));


        foodPresenter = new FoodPresenter(new FoodModel(), this);
    }

    @Override
    public void initData() {
        foodPresenter.doGET(page);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.huangguan1);
        list.add(R.drawable.huangguan2);
        list.add(R.drawable.huangguan3);

        banners.setIndicator(new CircleIndicator(getContext()));

        banners.setAdapter(new BannerImageAdapter<Integer>(list) {

            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });

        banners.setBannerGalleryMZ(50);
        banners.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        banners.setIndicatorSelectedColor(Color.RED);
        banners.setIndicatorNormalColor(Color.GREEN);

    }

    @Override
    public void FoodViews(List<FoodBean.DataBean> dataBeans) {
        smar.finishRefresh();
        smar.finishLoadMore();

        if (dapater==null){
            dapater = new Food_Dapater(dataBeans);
            res.setAdapter(dapater);

            dapater.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                    switch (view.getId()){
                        case R.id.jiagou:
                            UsersDao usersDao = UserManager.getInstance().usersDao;
                            usersDao.insert(new Users(null,dataBeans.get(position).getTitle(),
                                    dataBeans.get(position).getPic(),
                                    dataBeans.get(position).getNum(),0,false));
                            ToastUtils.showShort("添加成功");
                            break;
                    }
                }
            });
        }else{
            if (iRse){
                dapater.getData().clear();
            }
                dapater.getData().addAll(dataBeans);
               dapater.notifyDataSetChanged();
        }

    }

    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
       iRse = false;
       page++;
       foodPresenter.doGET(page);
    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {
        iRse = true;
        page=3;
        foodPresenter.doGET(page);
    }
}
