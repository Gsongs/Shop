package com.bawei.zhuangaowu114.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lib_croe.view.BaseFragment;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.mydapater.Tab_Dapater;
import com.bawei.zhuangaowu114.tabfragmen.Tab_one;
import com.bawei.zhuangaowu114.tabfragmen.Tab_tow;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:58
 *用途：
 */
class Fragment_My extends BaseFragment {
    private SlidingTabLayout tabs;
    private ViewPager vper;

    @Override
    public int bandLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        vper = (ViewPager) findViewById(R.id.vper);
    }

    @Override
    public void initData() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Tab_one());
        list.add(new Tab_tow());

        ArrayList<String> tit = new ArrayList<>();
        tit.add("快速登录");
        tit.add("账号密码登录");

        Tab_Dapater dapater = new Tab_Dapater(getChildFragmentManager(),list,tit);
        vper.setAdapter(dapater);
        tabs.setViewPager(vper);
    }
}
