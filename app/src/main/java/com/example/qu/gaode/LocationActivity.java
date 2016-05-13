package com.example.qu.gaode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.lidroid.xutils.http.RequestParams;

public class LocationActivity extends BaseActivity implements View.OnClickListener, LoadHttpUtils.GetListener {

    View view;
    private TextView location_buttom_txt_speed, location_buttom_txt_time, location_buttom_txt_state;
    private ImageView location_buttom_btn_history_path;
    OBDMapView mMapView = null;

    RequestParams params = new RequestParams();
    LoadHttpUtils lhttputil = new LoadHttpUtils(this);

    private int[] xingshi = new int[]{R.mipmap.car_green_up, R.mipmap.car_green_down, R.mipmap.car_green_left, R.mipmap.car_green_right, R.mipmap.car_green_left_up, R.mipmap.car_green_up_right, R.mipmap.car_green_down_left, R.mipmap.car_green_right_down};
    private int[] tingche = new int[]{R.mipmap.car_red_up, R.mipmap.car_red_down, R.mipmap.car_red_left, R.mipmap.car_red_right, R.mipmap.car_red_left_up, R.mipmap.car_red_up_right, R.mipmap.car_red_down_left, R.mipmap.car_red_right_down};
    private int[] guzhang = new int[]{R.mipmap.car_orange_up, R.mipmap.car_orange_down, R.mipmap.car_orange_left, R.mipmap.car_orange_right, R.mipmap.car_orange_left_up, R.mipmap.car_orange_up_right, R.mipmap.car_orange_down_left, R.mipmap.car_orange_right_down};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.activity_car__locus_, null);
        init();
        mMapView.onCreate(savedInstanceState);
        GetLoc_Car();//获取车位置
    }

    private void init() {
        location_buttom_txt_state = (TextView) view.findViewById(R.id.state);//状态
        location_buttom_txt_speed = (TextView) view.findViewById(R.id.street);//地址
        location_buttom_txt_time = (TextView) view.findViewById(R.id.time);//时间
        location_buttom_btn_history_path = (ImageView) view.findViewById(R.id.imgbtnhistory);
        location_buttom_btn_history_path.setOnClickListener(this);
        mMapView = (OBDMapView) view.findViewById(R.id.bmapView);
        fl_content.addView(view);
        mMapView.setOnLoacationClickListener(new OBDMapView.OnLoacationClickListener() {
            @Override
            public void onCarClick() {
                GetLoc_Car();//获取车位置
            }
        });

    }

    private void GetLoc_Car() {
        SharedPreferences sp = getSharedPreferences("login", 0);
        String id = sp.getString("id", "");
        params.addQueryStringParameter("customerId", id);
        lhttputil.Post(AppConstants.GETCARLOCATIONFORAPP, params, 0);
    }

    @Override
    public void getData(String str, int retrunType) {
        str = "{\"longitude\":\"120.404335\",\"latitude\":\"36.105198\",\"address\":\"山东省青岛市市北区辽源路街道青岛市中心聋校;距辽源路227号辽源路派出所西南102米; \",\"date\":\"2016-04-15 17:34:22\",\"status\":\"停车 熄火 离线\",\"dir\":\"4\",\"obdSpeed\":\"1\"}";

        Gpsinformation gpsinfo = JsonUtil.parseObject(str, Gpsinformation.class);
        if (gpsinfo.getAddress() != null) {
            gpsinfo.setAddress(gpsinfo.getAddress().split(";")[0].replace(" ", ""));
            //地址
            location_buttom_txt_speed.setText(gpsinfo.getAddress());
        }
        if (gpsinfo.getDate() != null) {
            //时间
            location_buttom_txt_time.setText(gpsinfo.getDate());
        }
        if (gpsinfo.getStatus() != null) {
            //车状态
            location_buttom_txt_state.setText(gpsinfo.getStatus());
        }
        //经纬度
        LatLng latLng = new LatLng(Double.valueOf(gpsinfo.getLatitude()), Double.valueOf(gpsinfo.getLongitude()));
        int pic = R.mipmap.car_gray;
        if (gpsinfo.getDir() != null && gpsinfo.getObdSpeed() != null) {
            int fangxiang = 0, state = 0;
            //状态
            state = Integer.parseInt(gpsinfo.getDir());
            //速度
            fangxiang = Integer.parseInt(gpsinfo.getObdSpeed()) - 1;
            if (state == 1) {//行驶状态
                pic = xingshi[fangxiang];
            } else if (state == 2) {//停车状态
                pic = tingche[fangxiang];
            } else if (state == 3) {//故障状态
                pic = guzhang[fangxiang];
            } else {
            }
        }
        mMapView.setCarLocaton(latLng, pic, gpsinfo.getAddress());//更改车图标
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbtnhistory:
                Intent intent = new Intent();
//                intent.setClass(this, PlayBackQueryActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy(), 实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mMapView.onResume();

        rl_nav.setVisibility(View.VISIBLE);
        ib_back.setVisibility(View.VISIBLE);
        btn_title.setText("位置");
        ib_right.setText("一键找车");
        ib_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMapView.searchCar();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mMapView.onSaveInstanceState(outState);
    }
}
