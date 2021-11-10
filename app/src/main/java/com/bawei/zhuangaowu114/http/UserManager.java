package com.bawei.zhuangaowu114.http;

import android.database.sqlite.SQLiteDatabase;

import com.bawie.lib_croe.db.DaoMaster;
import com.bawie.lib_croe.db.DaoSession;
import com.bawie.lib_croe.db.UsersDao;
import com.blankj.utilcode.util.Utils;

import okhttp3.internal.Util;

public

/**
 * 作者：王先生
 * 时间：2021/11/4 16:10
 * 用途：数据库单例了
 */
class UserManager {
    private volatile static UserManager manager;
    public  UsersDao usersDao;
    public static UserManager getInstance(){
        if (manager==null){
            synchronized (UserManager.class){
                manager = new UserManager();
            }
        }
        return manager;
    }


    public UserManager(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(Utils.getApp(),"name.db");
        SQLiteDatabase db = helper.getWritableDatabase();

        DaoMaster master = new DaoMaster(db);

        DaoSession daoSession = master.newSession();

        usersDao = daoSession.getUsersDao();
    }
}
