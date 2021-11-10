package com.bawei.zhuangaowu114.mydapater;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bawei.lib_croe.user.Users;
import com.bawei.zhuangaowu114.R;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/11/4 16:23
 *用途：
 */
class UserDapater extends BaseQuickAdapter<Users, BaseViewHolder> {
    public UserDapater(@Nullable List<Users> data) {
        super(R.layout.iter2, data);
        addChildClickViewIds(R.id.jia);
        addChildClickViewIds(R.id.shu);
        addChildClickViewIds(R.id.jian);
        addChildClickViewIds(R.id.chbox);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Users users) {
        Glide.with(getContext()).load(users.getPic()).into((ImageView) baseViewHolder.getView(R.id.img_g));
        baseViewHolder.setText(R.id.tvt1_g, users.getName());
        baseViewHolder.setText(R.id.tvt2_g, "" + users.getNum());
        baseViewHolder.setText(R.id.shu, "" + users.getPrices());

        CheckBox checkBox = baseViewHolder.getView(R.id.chbox);
        checkBox.setChecked(users.getIRse());
    }
}
