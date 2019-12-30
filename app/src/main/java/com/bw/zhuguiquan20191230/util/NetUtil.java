package com.bw.zhuguiquan20191230.util;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DateTime:2019/12/30 0030
 * author:朱贵全(Administrator)
 * function:
 */
public class NetUtil {
    private static NetUtil netUtil;
    private final Handler handler;
    private final OkHttpClient okHttpClient;

    private NetUtil() {
        handler = new Handler();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static NetUtil getInstance() {
        if(netUtil==null){
            synchronized (NetUtil.class){
                if(netUtil==null){
                    netUtil=new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void getJsonGet(String str, final MyCallback myCallback){
        final Request request = new Request.Builder()
                .get()
                .url(str)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallback.ongetError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.ongetJson(string);
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.ongetError(new Throwable("获取失败"));
                        }
                    });
                }

            }
        });
    }
    public void getJsonPost(String str, Map<String,String>map, final MyCallback myCallback){
        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet()){
            builder.add(key,map.get(key));
        }
        FormBody formBody = builder.build();
        final Request request = new Request.Builder()
                .post(formBody)
                .url(str)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallback.ongetError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.ongetJson(string);
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.ongetError(new Throwable("获取失败"));
                        }
                    });
                }

            }
        });
    }

    public interface MyCallback{
        void ongetJson(String string);
        void ongetError(Throwable  throwable);
    }
}
