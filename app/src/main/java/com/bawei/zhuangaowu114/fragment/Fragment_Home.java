package com.bawei.zhuangaowu114.fragment;

import android.Manifest;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bawei.lib_croe.view.BaseFragment;
import com.bawei.zhuangaowu114.R;
import com.bawei.zhuangaowu114.fragmentss.Vtab_for;
import com.bawei.zhuangaowu114.fragmentss.Vtab_one;
import com.bawei.zhuangaowu114.fragmentss.Vtab_three;
import com.bawei.zhuangaowu114.fragmentss.Vtab_tow;
import com.bawei.zhuangaowu114.mainactivity.Search;
import com.bawei.zhuangaowu114.mydapater.Vtab_Dapater;
import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/11/4 13:58
 *用途：地图 显示标签
 */
class Fragment_Home extends BaseFragment {
    private ImageView dingwei;
    private ImageView sousuo;
    private SlidingTabLayout tabss;
    private ViewPager vpers;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    double latitude;
    double longitude;
    String city;    //获取纬度信息

    @Override
    public int bandLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {

        dingwei = (ImageView) findViewById(R.id.dingwei);
        sousuo = (ImageView) findViewById(R.id.sousuo);
        tabss = (SlidingTabLayout) findViewById(R.id.tabss);
        vpers = (ViewPager) findViewById(R.id.vpers);

        requestPermissions(new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        },100);


        mLocationClient = new LocationClient(getContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true

        option.setNeedNewVersionRgc(true);
//可选，设置是否需要最新版本的地址信息。默认需要，即参数为true

        mLocationClient.setLocOption(option);

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认GCJ02
//GCJ02：国测局坐标；
//BD09ll：百度经纬度坐标；
//BD09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回WGS84类型坐标

        option.setScanSpan(1000);
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5*60*1000);
//可选，V7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前Wi-Fi是否超出有效期，若超出有效期，会先重新扫描Wi-Fi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

        option.setNeedNewVersionRgc(true);
//可选，设置是否需要最新版本的地址信息。默认需要，即参数为true

        mLocationClient.setLocOption(option);
    }

    @Override
    public void initData() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Vtab_one());
        list.add(new Vtab_tow());
        list.add(new Vtab_three());
        list.add(new Vtab_for());

        ArrayList<String> title = new ArrayList<>();
        title.add("热卖");
        title.add("防护");
        title.add("个人");
        title.add("感冒");

        Vtab_Dapater dapater = new Vtab_Dapater(getChildFragmentManager(),list,title);
        vpers.setAdapter(dapater);
        tabss.setViewPager(vpers);


        //地图显示
        mLocationClient.start();
        dingwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("经度"+longitude+"纬度"+latitude+"城市"+city);
            }
        });

        //搜索页面
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Search.class);
                startActivity(intent);
            }
        });


    }
    //地图方法
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location){
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明


            latitude = location.getLatitude();
               //获取经度信息
            longitude = location.getLongitude();
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

            int errorCode = location.getLocType();


            city = location.getCity();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
        }
    }
}
