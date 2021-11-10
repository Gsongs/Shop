package com.bawei.zhuangaowu114.mydapater;

import android.widget.ImageView;

import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.json.FoodBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/11/4 15:47
 *用途：
 */
class Food_Dapater extends BaseMultiItemQuickAdapter<FoodBean.DataBean, BaseViewHolder> {
    public Food_Dapater(@Nullable List<FoodBean.DataBean> data) {
        super(data);
        addItemType(0, R.layout.iter);
        addChildClickViewIds(R.id.jiagou);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, FoodBean.DataBean dataBean) {
        if (dataBean.getIndex()==0){
            Glide.with(getContext()).load(dataBean.getPic()).into((ImageView) baseViewHolder.getView(R.id.imgs1));
            baseViewHolder.setText(R.id.tv1,dataBean.getTitle());
            baseViewHolder.setText(R.id.tv2,dataBean.getFood_str());
            baseViewHolder.setText(R.id.tv3,""+dataBean.getNum());
        }
    }
}
