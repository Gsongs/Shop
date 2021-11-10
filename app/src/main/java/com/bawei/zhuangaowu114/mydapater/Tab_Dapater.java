package com.bawei.zhuangaowu114.mydapater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/11/4 14:13
 *用途：
 */
class Tab_Dapater extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    ArrayList<String> tit;

    public Tab_Dapater(@NonNull @NotNull FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> tit) {
        super(fm);
        this.list = list;
        this.tit = tit;
    }


    @NotNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tit.get(position);
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
    }
}
