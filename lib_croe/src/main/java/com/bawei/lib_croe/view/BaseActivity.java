package com.bawei.lib_croe.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.lib_croe.presenetr.IPresenter;

public abstract
/**
 *作者：王先生
 *时间：2021/11/4 13:08
 *用途：
 */
class BaseActivity <P extends IPresenter> extends AppCompatActivity implements IActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.destroy();
            mPresenter=null;
        }
    }
}
