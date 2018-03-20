package com.ingdan.base.common.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import com.google.gson.Gson;
import com.ingdan.base.common.base.BaseApplication;
import com.ingdan.base.common.config.BaseConfig;
import com.ingdan.base.common.model.BaiDuLocationBean;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by geekqian on 2018/3/19.
 * 描述: 定位帮助类
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class LocationUtils {

    private static String sLocation = "";

    /** 获取缓存中的位置
     * @return
     */
    public static String getCacheLocation(){
        return sLocation;
    }


    /** 获取地理位置
     * @return 地理位置
     */
    public static String getLocation(){
        sLocation = SPUtils.getString(BaseConfig.LOCATION, "");
        LocationManager manager = (LocationManager) BaseApplication.getContext().getSystemService(Context.LOCATION_SERVICE);//获得位置服务
        if (manager == null) return "";

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);//低精度，如果设置为高精度，依然获取不了location。
        criteria.setAltitudeRequired(false);//不要求海拔
        criteria.setBearingRequired(false);//不要求方位
        criteria.setCostAllowed(true);//允许有花费
        criteria.setPowerRequirement(Criteria.POWER_LOW);//低功耗
        //从可用的位置提供器中，匹配以上标准的最佳提供器
        String provider = manager.getBestProvider(criteria, true);
        if (provider == null) return "";

        // 判断是否有权限,  ACCESS_FINE_LOCATION 获取精确位置   ACCESS_COARSE_LOCATION 获取错略位置
        if (ActivityCompat.checkSelfPermission(BaseApplication.getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(BaseApplication.getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }

        Location location = manager.getLastKnownLocation(provider);
        if (location != null) {
            getLocationFormBaiDu(location);//得到当前经纬度并开启线程去反向地理编码
        }

        //        manager.requestLocationUpdates(provider, 0, 0, new LocationListener(){
        //
        //            @Override
        //            public void onLocationChanged(Location location) {
        //                LogUtils.print( "onLocationChanged: " + location + ".." + Thread.currentThread().getName());
        //                //如果位置发生变化,重新查询
        //                getLocationFormBaiDu(location);
        //            }
        //
        //            @Override
        //            public void onStatusChanged(String provider, int status, Bundle extras) {
        //
        //            }
        //
        //            @Override
        //            public void onProviderEnabled(String provider) {
        //                LogUtils.print("onProviderEnabled: " + provider + ".." + Thread.currentThread().getName());
        //            }
        //
        //            @Override
        //            public void onProviderDisabled(String provider) {
        //                LogUtils.print("onProviderDisabled: " + provider + ".." + Thread.currentThread().getName());
        //            }
        //        });

        return sLocation;
    }

    /** 调用百度在线API获取详细位置
     * @param location 位置
     */
    private static void getLocationFormBaiDu(Location location) {
        double lng = location.getLongitude();
        double lat = location.getLatitude();
        // 用location获取到的坐标是地球坐标,要把地球坐标转换为百度坐标
        JZLocationConverter.LatLng latLng = JZLocationConverter.wgs84ToBd09(new JZLocationConverter.LatLng(lat, lng));
        String longitude = latLng.longitude +"";
        String latitude = latLng.latitude + "";

        String ak = BaseConfig.BAIDU_AK;
        String mCode = BaseConfig.MCODE;
        final String url = "http://api.map.baidu.com/geocoder/v2/?location="
                + latitude + "," + longitude + "&output=json&pois=1&ak=" + ak + "&mcode=" + mCode;

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtils.print("百度地址请求失败 >>>>>" + e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        try {
                            String string = response.body().string();
                            Gson gson = new Gson();
                            BaiDuLocationBean locationBean = gson.fromJson(string, BaiDuLocationBean.class);
                            if (locationBean != null) {
                                BaiDuLocationBean.ResultBean result = locationBean.getResult();
                                String address = result.getFormatted_address();
                                sLocation = address;
                                LogUtils.print("address == " + address);
                                // 把地址保存到sp
                                SPUtils.putString(BaseConfig.LOCATION , address);
                            }
                        } catch (Exception e) {
                            LogUtils.print("百度地址解析失败 >>>>>" + response);
                        }
                    }
                });
            }
        }).start();
    }
}
