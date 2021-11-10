package com.bawei.lib_croe.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.lib_croe.presenetr.IPresenter;

public abstract
/**
 *作者：王先生
 *时间：2021/11/4 13:08
 *用途：
 */
class BaseFragment<P extends IPresenter> extends Fragment implements IFragment {

    protected  P mPres;
    protected View view;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return view=inflater.inflate(bandLayout(),container,false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return view.findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPres!=null){
            mPres.destroy();
            mPres=null;
        }
    }
}
