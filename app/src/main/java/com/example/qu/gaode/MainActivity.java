package com.example.qu.gaode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    OBDMapView mMapView = null;
    View view;
    private FrameLayout fl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = View.inflate(this, R.layout.activity_car__locus_, null);
        //获取地图控件引用
        mMapView = (OBDMapView) view.findViewById(R.id.bmapView);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState), 实现地图生命周期管理
        initView();
        mMapView.onCreate(savedInstanceState);
    }

    private void initView() {
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        fl_content.addView(view);
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
