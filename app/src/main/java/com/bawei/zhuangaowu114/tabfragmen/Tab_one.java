package com.bawei.zhuangaowu114.tabfragmen;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.bawei.lib_croe.view.BaseFragment;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.mainactivity.HomeActivity;
import com.blankj.utilcode.util.ToastUtils;

import java.util.Random;

public
/**
 *作者：王先生
 *时间：2021/11/4 14:11
 *用途：二.我的页面
 */
class Tab_one extends BaseFragment {
    private EditText sjh;
    private EditText yzm;
    private Button fsyz;
    private CheckBox gouxuan;
    private Button deng;
    int a;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    fsyz.setText(msg.obj+"s");

                    a = (int) msg.obj;
                    break;
            }
        }
    };

    @Override
    public int bandLayout() {
        return R.layout.tab_one;
    }

    @Override
    public void initView() {

        sjh = (EditText) findViewById(R.id.sjh);
        yzm = (EditText) findViewById(R.id.yzm);
        fsyz = (Button) findViewById(R.id.fsyz);
        gouxuan = (CheckBox) findViewById(R.id.gouxuan);
        deng = (Button) findViewById(R.id.deng);
    }

    @Override
    public void initData() {
        //发送验证码
        fsyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    Random random = new Random();
                    double v1 = random.nextDouble();
                    int  v2 = (int) (v1 * 1000000);

                  /*  yzm.setText(""+v2);*/

                    Notification notification = new Notification.Builder(getContext()).setSmallIcon(R.drawable.back)
                            .setContentTitle("您的验证码是")
                            .setContentText(""+v2)
                            .build();

                    NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(1,notification);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 60; i >=0; i--) {
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
        });


        //登录
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gouxuan.isChecked()){
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                }else{
                    ToastUtils.showShort("没有勾选不允许登录");
                }
            }
        });
    }
}
