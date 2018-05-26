//package com.test.xy.demo.modle.net;
//
//import com.test.xy.demo.global.Configure;
//import com.test.xy.demo.modle.entity.BaseEntity;
//import com.test.xy.demo.modle.entity.CodeEntity;
//import com.test.xy.demo.modle.entity.LoginEntity;
//
//import io.reactivex.Observable;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
//
///**
// * API接口类
// */
//public class ApiService {
//
//    private static ApiInterface apiInterface;
//
//    public static void initApiService(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(OkhttpUtils.okHttpClient)
//                .baseUrl(Configure.BASE_URL)
//                .addConverterFactory(MyConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        apiInterface = retrofit.create(ApiInterface.class);
//    }
//    /**
//     * 校验token
//     */
//    public static Observable<BaseEntity<LoginEntity>> checkToken(String token) {
//        return apiInterface.refreshToken(token)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    /**
//     * 登录
//     */
//    public static Observable<BaseEntity<LoginEntity>> postLogin(Object object) {
//        return apiInterface.postLogin(OkhttpUtils.getBody(object))
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    /**
//     * 注册
//     */
//    public static Observable<BaseEntity<LoginEntity>> postRegister(Object object) {
//        return apiInterface.postRegister(OkhttpUtils.getBody(object))
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
//
//    }
//
//    /**
//     * 获取验证码
//     */
//    public static Observable<BaseEntity<CodeEntity>> getCode(String phone, String type) {
//        return apiInterface.getCode(phone, type)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//}
