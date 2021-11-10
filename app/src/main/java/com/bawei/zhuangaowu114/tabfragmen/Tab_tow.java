package com.bawei.zhuangaowu114.tabfragmen;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.bawei.lib_croe.view.BaseFragment;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.mainactivity.HomeActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public
/**
 *作者：王先生
 *时间：2021/11/4 14:11
 *用途：
 */
class Tab_tow extends BaseFragment {
    private TextView dneglu;
    private ImageView qq;
    private ImageView weixin;

    @Override
    public int bandLayout() {
        return R.layout.tab_tow;
    }

    @Override
    public void initView() {

        dneglu = (TextView) findViewById(R.id.dneglu);
        qq = (ImageView) findViewById(R.id.qq);
        weixin = (ImageView) findViewById(R.id.weixin);
    }

    @Override
    public void initData() {

        dneglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=23){
                    String[] mPermissionList =new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
                    ActivityCompat.requestPermissions(getActivity(),mPermissionList,123);
                }

                UMConfigure.init(getContext(),"5a12384aa40fa3551f0001d1"
                        ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2

                // QQ设置
                PlatformConfig.setQQZone("101830139","5d63ae8858f1caab67715ccd6c18d7a5");
                PlatformConfig.setQQFileProvider("com.tencent.sample2.fileprovider");

                UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.ALIPAY.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        ToastUtils.showShort("正在登录");
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        ToastUtils.showShort("登录失败");
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });
    }
}
