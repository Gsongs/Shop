package com.bawei.zhuangaowu114.mainactivity;

import android.content.SharedPreferences;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.bawei.lib_croe.view.BaseActivity;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.fragment.Fragment_Face;
import com.bawei.zhuangaowu114.fragment.Fragment_Home;
import com.bawei.zhuangaowu114.fragment.Fragment_List;
import com.bawei.zhuangaowu114.fragment.Fragment_My;
import com.bawei.zhuangaowu114.fragment.Fragment_Shop;
import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:43
 *用途：
 */
class HomeActivity extends BaseActivity {
    private android.widget.LinearLayout lab;
    private com.chaychan.library.BottomBarLayout bottomLab;

    @Override
    public int bandLayout() {
        return R.layout.home;
    }

    @Override
    public void initView() {

        lab = (LinearLayout) findViewById(R.id.lab);
        bottomLab = (BottomBarLayout) findViewById(R.id.bottom_lab);
    }

    @Override
    public void initData() {
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        SharedPreferences.Editor edit = name.edit();
        edit.putBoolean("is",true)
                .commit();


        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Fragment_Home());
        list.add(new Fragment_Shop());
        list.add(new Fragment_Face());
        list.add(new Fragment_List());
        list.add(new Fragment_My());


        getSupportFragmentManager().beginTransaction()
                .add(R.id.lab,list.get(0))
                .commit();

        bottomLab.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int previousPosition, int currentPosition) {
                if (previousPosition==0&&previousPosition==currentPosition&&!list.get(currentPosition).isAdded()){
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.lab,list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
                if (previousPosition!=currentPosition&&!list.get(currentPosition).isAdded()){
                    getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .add(R.id.lab,list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
                if (previousPosition!=currentPosition){
                    getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .show(list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
            }
        });
    }
}
