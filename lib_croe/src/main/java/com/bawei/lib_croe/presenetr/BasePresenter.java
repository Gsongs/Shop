package com.bawei.lib_croe.presenetr;

import com.bawei.lib_croe.model.IModel;
import com.bawei.lib_croe.view.IView;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:08
 *用途：
 */
class BasePresenter <M extends IModel,V extends IView> implements IPresenter{

    protected M mModle;
    protected V views;

    public BasePresenter(M mModle, V views) {
        this.mModle = mModle;
        this.views = views;
    }

    @Override
    public void destroy() {
        if (mModle!=null){
            mModle.destroy();
            mModle=null;
        }
        if (views!=null){
            views=null;
        }
    }
}
