package com.bawei.lib_croe.view;

import android.view.View;

import androidx.annotation.IdRes;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:07
 *用途：
 */
interface IFragment extends IActivity{

    <T extends View> T findViewById(@IdRes int id);
}
