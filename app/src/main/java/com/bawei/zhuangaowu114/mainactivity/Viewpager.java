package com.bawei.zhuangaowu114.mainactivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bawei.lib_croe.view.BaseActivity;
import com.bawei.zhuangaowu114.R;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:20
 *用途：APP加载页面
 */
class Viewpager extends BaseActivity {
    private android.widget.ImageView imgs;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    int a = (int) msg.obj;
                    if (a == 0) {

                        Intent intent = new Intent(Viewpager.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    };


    @Override
    public int bandLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        imgs = (ImageView) findViewById(R.id.imgs);
    }

    @Override
    public void initData() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i >=0; i--) {
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage();
                        message.what=1;
                        message.obj=i;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
