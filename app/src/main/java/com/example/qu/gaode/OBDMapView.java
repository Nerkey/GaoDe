package com.example.qu.gaode;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class OBDMapView extends FrameLayout implements View.OnClickListener, LocationSource, AMapLocationListener {

    private ImageView btn_loc_peo; //人
    private ImageView btn_loc_car; //车
    private ImageView btn_zoom_in; //放大
    private ImageView btn_zoom_out; //缩小

    private AMap aMap;
    private MapView mapView;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private MarkerOptions markerOption;
    private LatLng carLatLng;
    private String carAddress;

    double lat, lng;

    public OBDMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMap();
    }

    /**
     * 初始化地图
     */
    private void initMap() {
        LayoutInflater mLayoutInflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        view = mLayoutInflater.inflate(R.layout.view_my_mapview, this, true);
        mapView = (MapView) view.findViewById(R.id.map); //获取mapView的引用

        aMap = mapView.getMap(); //获取地图引用
        aMap.setLocationSource(this);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        btn_loc_peo = (ImageView) view.findViewById(R.id.btn_loc_peo);
        btn_loc_car = (ImageView) view.findViewById(R.id.btn_loc_car);
        btn_zoom_in = (ImageView) view.findViewById(R.id.btn_zoom_in);
        btn_zoom_out = (ImageView) view.findViewById(R.id.btn_zoom_out);
        btn_loc_peo.setOnClickListener(this);
        btn_loc_car.setOnClickListener(this);
        btn_zoom_in.setOnClickListener(this);
        btn_zoom_out.setOnClickListener(this);
    }


    boolean isFirstLocation = true;

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null
                    && aMapLocation.getErrorCode() == 0) {
                double lat = aMapLocation.getLatitude();
                double lng = aMapLocation.getLongitude();
                if (isFirstLocation) {
                    // 显示系统小蓝点
                    mListener.onLocationChanged(aMapLocation);

                    MyLocationStyle myLocationStyle = new MyLocationStyle();
                    myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.location_user));
                    myLocationStyle.strokeColor(Color.BLUE);
                    myLocationStyle.radiusFillColor(Color.argb(125, 200, 255, 255));// 设置圆形的填充颜色
                    myLocationStyle.strokeWidth(1);

                    aMap.setMyLocationStyle(myLocationStyle);
                    isFirstLocation = false;

                    aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                            new LatLng(lat, lng), 15, 0, 0)), 500, null); //定位到当前手机位置
                }
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(getContext());
            mLocationOption = new AMapLocationClientOption();
            aMap.getUiSettings().setMyLocationButtonEnabled(false);
            aMap.getUiSettings().setZoomControlsEnabled(false);
            //设置定位间隔,单位毫秒,默认为2000ms
            mLocationOption.setInterval(3000);
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loc_peo:
                getPeopleLocation();
                break;
            case R.id.btn_loc_car:
                getCarLocation();
                break;
            case R.id.btn_zoom_in:
                zoomIn();
                break;
            case R.id.btn_zoom_out:
                zoomOut();
                break;
        }
    }

    Handler mHandler = new Handler();
    Runnable reFreshCarPos = new Runnable() {
        @Override
        public void run() {
//            getCarLocation();
            mHandler.postDelayed(this, 3000);
        }
    };

    boolean isCustom = false; //是否手动定位

    //定位人的位置
    private void getPeopleLocation() {
        isCustom = true;
        if (!aMap.isMyLocationEnabled())
            aMap.setMyLocationEnabled(true);
        if (!mlocationClient.isStarted())
            mlocationClient.startLocation();
        mHandler.removeCallbacks(reFreshCarPos);

        Location location = aMap.getMyLocation();
        lat = location.getLatitude();
        lng = location.getLongitude();
        aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(lat, lng), 15, 0, 0)), 500, null); //定位到当前手机位置
    }

    //定位车的位置
    private void getCarLocation() {
        if (!aMap.isMyLocationEnabled())
            aMap.setMyLocationEnabled(true);
        if (mlocationClient.isStarted())
            mlocationClient.stopLocation();
        if (onLoacationClickListener != null)
            onLoacationClickListener.onCarClick();
    }

    public void setIconGone() {
        btn_loc_peo.setVisibility(View.GONE);
        btn_loc_car.setVisibility(View.GONE);
    }

    public void searchCar() {
        try {
            String startLat = aMap.getMyLocation().getLatitude() + "";
            String startLng = aMap.getMyLocation().getLongitude() + "";
            String startName = aMap.getMyLocation().getExtras().get("desc").toString();

            String endLat = carLatLng.latitude + "";
            String endLng = carLatLng.longitude + "";
            String endName = carAddress;

            Intent intent = new Intent("android.intent.action.VIEW",
                    android.net.Uri.parse("androidamap://route?sourceApplication=aa&slat=" + startLat + "&slon=" + startLng + "&sname=" + startName + "&dlat=" + endLat + "&dlon=" + endLng + "&dname=" + endName + "&dev=0&m=0&t=4"));
            intent.setPackage("com.autonavi.minimap");
            getContext().startActivity(intent);
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    getContext());
            builder.setMessage("您尚未安装高德地图app或app版本过低，点击确认安装？");
            builder.setTitle("提示");
            builder.setPositiveButton("确认",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();
                            Intent var1 = new Intent();
                            var1.setAction("android.intent.action.VIEW");
                            Uri var2 = Uri.parse("http://wap.amap.com/");
                            var1.setData(var2);
                            getContext().startActivity(var1);
                        }
                    });
            builder.setNegativeButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();
                        }
                    });
            builder.create().show();
        }
    }

    public void drivingRoute(List<DPoint> pts) {

        if (pts == null || pts.size() < 2)
            return;
        if (mlocationClient.isStarted())
            mlocationClient.stopLocation();
        aMap.clear();
        markPoint(pts.get(0).getLatitude(), pts.get(0).getLongitude(),
                R.drawable.icon_begin);
        markPoint(pts.get(pts.size() - 1).getLatitude(),
                pts.get(pts.size() - 1).getLongitude(), R.drawable.icon_end);
        mHandler.removeCallbacks(reFreshCarPos);

        PolylineOptions options = new PolylineOptions().width(5)
                .color(0xAA6581f5).add(new LatLng(pts.get(0).getLatitude(), pts.get(0).getLongitude()));
        for (int i = 1; i < pts.size(); i++) {
            options.add(new LatLng(pts.get(i).getLatitude(), pts.get(i).getLongitude()));
        }
        aMap.addPolyline(options);
        aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(pts.get(0).getLatitude(), pts.get(0).getLongitude()), 15, 0, 0)), 500, null); //定位到当前车位置
        LatLng data = new LatLng(pts.get(0).getLatitude(), pts.get(0).getLongitude());
    }

    Marker marker;

    private void markPoint(double latitude, double longitude, int drawable) {
        markerOption = new MarkerOptions();
        markerOption.position(new LatLng(latitude, longitude));
        markerOption.draggable(true);
        markerOption.icon(
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                drawable)));
        markerOption.setFlat(true);
        marker = aMap.addMarker(markerOption);
    }

    private void zoomOut() {
        aMap.animateCamera(CameraUpdateFactory.zoomOut(), 500, null);
    }

    private void zoomIn() {
        aMap.animateCamera(CameraUpdateFactory.zoomIn(), 500, null);
    }

    OnLoacationClickListener onLoacationClickListener;

    public void setOnLoacationClickListener(
            OnLoacationClickListener onLoacationClickListener) {
        this.onLoacationClickListener = onLoacationClickListener;
    }

    public interface OnLoacationClickListener {
        void onCarClick();

    }

    public void setCarLocaton(LatLng locData, int drawable, String address) {
        this.carLatLng = locData;
        this.carAddress = address;
        markerOption = new MarkerOptions();
        markerOption.position(locData);
        markerOption.draggable(true);
        markerOption.icon(
                // BitmapDescriptorFactory
                // .fromResource(R.drawable.location_marker)
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                drawable)));
        // 将Marker设置为贴地显示，可以双指下拉看效果
        markerOption.setFlat(true);
        aMap.addMarker(markerOption);
        aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(locData.latitude, locData.longitude), 15, 0, 0)), 500, null); //定位到当前车位置
    }

    public void drivingRouteStop(List<DPoint> pts, int num) {
        if (pts == null || pts.size() < 2)
            return;
        if (num != 0) {
            marker.remove();
        }
    }

    public void drivingRoute(List<DPoint> pts, int num) {
        if (pts == null || pts.size() < 2)
            return;
        if (num != 0) {
            marker.remove();
        }
        markPoint(pts.get(num).getLatitude(), pts.get(num).getLongitude(),
                R.drawable.locate_car01);
    }

    protected void onCreate(Bundle savedInstanceState) {
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState), 实现地图生命周期管理
        mapView.onCreate(savedInstanceState);
    }

    protected void onDestroy() {
        //在activity执行onDestroy时执行mMapView.onDestroy(), 实现地图生命周期管理
        mapView.onDestroy();
    }

    protected void onResume() {
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    protected void onPause() {
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    protected void onSaveInstanceState(Bundle outState) {
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mapView.onSaveInstanceState(outState);
    }
}
