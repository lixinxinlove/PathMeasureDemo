package com.love.lixinxin.pathmeasuredemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.love.lixinxin.pathmeasuredemo.http.IRequest;
import com.love.lixinxin.pathmeasuredemo.http.impl.BaseRequest;
import com.love.lixinxin.pathmeasuredemo.http.impl.BaseResponse;
import com.love.lixinxin.pathmeasuredemo.http.impl.OkHttpClientImpl;

public class MainActivity extends AppCompatActivity {

    BaseResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final OkHttpClientImpl okHttpClient = new OkHttpClientImpl();
        final BaseRequest baseRequest = new BaseRequest("http://gank.io/api/data/Android/10/1");
        baseRequest.setMethod(IRequest.GET);


        new Thread(new Runnable() {
            @Override
            public void run() {
                response= (BaseResponse) okHttpClient.get(baseRequest, true);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("lxx",response.getData());
                    }
                });
            }
        }).start();

    }
}
