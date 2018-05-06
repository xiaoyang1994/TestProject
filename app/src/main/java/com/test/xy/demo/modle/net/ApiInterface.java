package com.test.xy.demo.modle.net;

import com.test.xy.demo.global.Configure;
import com.test.xy.demo.modle.entity.BaseEntity;
import com.test.xy.demo.modle.entity.CodeEntity;
import com.test.xy.demo.modle.entity.LoginEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * api接口
 */
public interface ApiInterface {
    /**
     * token校验
     */
    @GET("auth/refresh")
    Observable<BaseEntity<LoginEntity>>
    refreshToken(@Header(Configure.TOKEN_KEY) String token);

    /**
     * 登录
     */
    @POST("auth/login")
    Observable<BaseEntity<LoginEntity>>
    postLogin(@Body RequestBody requestBody);

    /**
     * 注册
     */
    @POST("auth/register")
    Observable<BaseEntity<LoginEntity>>
    postRegister(@Body RequestBody requestBody);

    /**
     * 获取验证码
     */
    @GET("auth/code/{mobile}/{type}")
    Observable<BaseEntity<CodeEntity>>
    getCode(@Path("mobile") String phone,
            @Path("type") String type);
}
