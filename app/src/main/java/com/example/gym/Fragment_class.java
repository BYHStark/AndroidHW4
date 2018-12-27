package com.example.gym;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.SDKInitializer;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
//import com.baidu.mapapi.overlayutil.DrivingRouteOverlay;
//import com.baidu.mapapi.overlayutil.OverlayManager;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;

import java.util.ArrayList;
import java.util.List;
//import com.baidu.mapapi.overlayutil.WalkingRouteOverlay;

public class Fragment_class extends Fragment{
    private List<ItemClass> mItemContentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_class,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initItemContent();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycle_class);
        LinearLayoutManager linerManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linerManager);
        ClassAdapter adapter = new ClassAdapter (this,mItemContentList );
        recyclerView.setAdapter(adapter);



    }
    private void initItemContent() {

        ItemClass kola1 = new ItemClass("Running",R.drawable.bat,"Running is an Attitude");
        ItemClass kola2 = new ItemClass("Swimming",R.drawable.iron,"Become Thinner");
        ItemClass kola3 = new ItemClass("Basketball",R.drawable.sylvanas,"Burn my calorie");
        ItemClass kola4 = new ItemClass("Badminton",R.drawable.sports1,"Shuttlexcock");
        mItemContentList .add(kola1);
        mItemContentList .add(kola2);
        mItemContentList .add(kola3);
        mItemContentList .add(kola4);





    }

}


//public class Fragment_class extends Fragment{
//    private MapView mMapView;
//    private BaiduMap mBaiduMap;
//    private RoutePlanSearch myMapSearch;
//    private OnGetRoutePlanResultListener listener;
//
//    private Button btn_myroute,btn_changeview;
//    private Switch btn_istraffic;
//    private TextView longti, lati;
//    private LocationManager locationManager;
//    private String provider;
//    //定位相关
//    private LocationClient locationClient;
//    private MyLocationListener myLocationListener;
//    private boolean isFirstIn = true;
//    private double myLatitude;
//    private double myLongtitude;
//    //自定义定位图标相关
//    private BitmapDescriptor bitmapDescriptor;
//    private float mCurrentX;
//    private MyOrientationlistener mMyOrientationListener;
//    private static final int REQUEST_LOCATION_PERMISSION = 200;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        SDKInitializer.initialize(getActivity().getApplicationContext());
//        View view=inflater.inflate(R.layout.fragment_class,container,false);
//        mMapView = (MapView)view.findViewById(R.id.bmapView);
//
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
//        mBaiduMap = mMapView.getMap();
//        mBaiduMap.setMapStatus(msu);
////        // Get the location manager
////        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
////        // Define the criteria how to select the locatioin provider -> use
////        // default
////        Criteria criteria = new Criteria();
////        provider = locationManager.getBestProvider(criteria, false);
////        //Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
////        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////
////            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
////        }
////        else {
////            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
////
////            // Initialize the location fields
////            if (location != null) {
////                System.out.println("Provider " + provider + " has been selected.");
////                onLocationChanged(location);
////            }
////        }
//        initLocation();
//       // add_mark();
//    }
//    //初始化定位
//    @Override
//    public void onStart() {
//        super.onStart();
//        //开始定位
//        mBaiduMap.setMyLocationEnabled(true);
//        if (!locationClient.isStarted()){
//            locationClient.start();}
//
//    }
//    //停止定位
//    @Override
//    public void onStop() {
//        super.onStop();
//        //停止定位
//        mBaiduMap.setMyLocationEnabled(false);
//        locationClient.stop();
//        //停止方向传感器
//        mMyOrientationListener.stop();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
//        mMapView.onDestroy();
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
//        mMapView.onResume();
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
//        mMapView.onPause();
//    }
//    private void initLocation(){
//         //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
//        locationClient = new LocationClient(getContext().getApplicationContext());
////声明LocationClient类实例并配置定位参数
//        LocationClientOption locationOption = new LocationClientOption();
//        MyLocationListener myLocationListener = new MyLocationListener();
//        locationClient.registerLocationListener(myLocationListener);
//        locationOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        locationOption.setCoorType("bd09ll");
//        locationOption.setScanSpan(1000);
//        locationOption.setIsNeedAddress(true);
//        locationOption.setIsNeedLocationDescribe(true);
//        locationOption.setNeedDeviceDirect(false);
//        locationOption.setLocationNotify(true);
//        locationOption.setIgnoreKillProcess(true);
//        locationOption.setIsNeedLocationDescribe(true);
//        locationOption.setIsNeedLocationPoiList(true);
//        locationOption.SetIgnoreCacheException(false);
//        locationOption.setOpenGps(true);
//        locationOption.setIsNeedAltitude(false);
//        locationOption.setOpenAutoNotifyMode();
//        locationOption.setOpenAutoNotifyMode(3000,1, LocationClientOption.LOC_SENSITIVITY_HIGHT);
//
//        locationClient.setLocOption(locationOption);
//        locationClient.start();
//        //初始化图标
//        bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.running);
//        mMyOrientationListener = new MyOrientationlistener(getContext());
//        mMyOrientationListener.setOnOrientationListener(new MyOrientationlistener.OnOrientationListener() {
//            @Override
//            public void onOrientationChange(float x) {
//                mCurrentX = x;
//            }
//        });
//
//    }
//
//    //定位监听类
//    private class MyLocationListener extends BDAbstractLocationListener{
//        @Override
//        public void onReceiveLocation(BDLocation bdLocation) {
//            MyLocationData myLocationData = new MyLocationData.Builder().accuracy(bdLocation.getRadius())//
//                    .direction(mCurrentX).latitude(bdLocation.getLatitude()).longitude(bdLocation.getLongitude()).build();
//            mBaiduMap.setMyLocationData(myLocationData);
//            //设置经纬度
//            myLatitude = bdLocation.getLatitude();
//            myLongtitude = bdLocation.getLongitude();
//
//            //设置定位图标
//            MyLocationConfiguration configuration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true,bitmapDescriptor);
//            mBaiduMap.setMyLocationConfigeration(configuration);
//            if (isFirstIn){
//                LatLng latLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
//                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
//                //MapStatusUpdate msu = MapStatusUpdateFactory.zoomBy(2);
//                mBaiduMap.animateMapStatus(msu);
//                isFirstIn = false;
//                //Toast.makeText(,bdLocation.getAddrStr(),Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//
//    public void onLocationChanged(Location location) {
//        myLatitude = location.getLatitude();
//        myLongtitude = location.getLongitude();
//
//        double lat = (double) (location.getLatitude());
//
//
//        double lng = (double) (location.getLongitude());
//
//        lati.setText(String.valueOf(lat));
//        longti.setText(String.valueOf(lng));
//    }
//
//}