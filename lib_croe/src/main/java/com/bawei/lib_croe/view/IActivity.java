package com.bawei.lib_croe.view;

import androidx.annotation.LayoutRes;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:07
 *用途：
 */
interface IActivity {

    @LayoutRes
    int bandLayout();

    void initView();

    void initData();
}
