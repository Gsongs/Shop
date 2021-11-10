package com.bawei.zhuangaowu114.mainactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import com.bawei.lib_croe.view.BaseActivity;
import com.bawei.zhuangaowu114.R;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:22
 *用途：
 */
class LoginActivity extends BaseActivity {
    private android.widget.Button butongyi;
    private android.widget.Button tongyi;

    @Override
    public int bandLayout() {
        return R.layout.login;
    }

    @Override
    public void initView() {

        butongyi = (Button) findViewById(R.id.butongyi);
        tongyi = (Button) findViewById(R.id.tongyi);
    }

    @Override
    public void initData() {
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        boolean is = name.getBoolean("is", true);
        if (is){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }else{
            butongyi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishAffinity();
                }
            });

            tongyi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
}
