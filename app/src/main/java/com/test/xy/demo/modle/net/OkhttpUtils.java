package com.test.xy.demo.modle.net;

import android.content.Context;
import android.provider.Settings;

import com.google.gson.Gson;
import com.test.xy.demo.utils.CommonUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


public class OkhttpUtils {
    public static OkHttpClient okHttpClient;
    public static OkHttpClient tokenClient;
    public static OkHttpClient WXClient;
    public static String DEVICE_ID;
    public static String DEVICE_INFO;

    public static void init(Context context) {
        DEVICE_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);

        DEVICE_INFO = "Brand:" + android.os.Build.BRAND + "Model :" + android.os.Build.MODEL + "Version:Android" + android.os.Build.VERSION.RELEASE;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(mHeaderInterceptor)//添加拦截器
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 添加头信息拦截器
     */
    private static final Interceptor mHeaderInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder()
                    .header("device_id", DEVICE_ID)// 添加装置id
                    .header("device_info", DEVICE_INFO)// 添加装置信息
                    .header("os", "android")
                    .header("version", CommonUtils.getVersion());//版本号
            Response response = chain.proceed(builder.build());
            return response;
        }
    };

    /**
     * 获取RequestBody
     * @param object
     * @return
     */
    public static RequestBody getBody(Object object){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(object));
        return requestBody;
    }
}
