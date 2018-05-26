//package com.test.xy.demo.modle.net;
//
//import android.text.TextUtils;
//
//import com.google.gson.Gson;
//import com.test.xy.demo.modle.entity.BaseEntity;
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Type;
//
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import retrofit2.Converter;
//import retrofit2.Retrofit;
//
//
//public class MyConverterFactory extends Converter.Factory{
//    private final Gson gson;
//
//    public MyConverterFactory(Gson gson) {
//        this.gson = gson;
//    }
//
//    public static MyConverterFactory create() {
//        return create(new Gson());
//    }
//
//    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
//    public static MyConverterFactory create(Gson gson) {
//        if (gson == null) throw new NullPointerException("gson == null");
//        return new MyConverterFactory(gson);
//    }
//
//    @Override
//    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
//                                                            Retrofit retrofit) {
//        return new MyResponseConverter<>(gson, type);
//    }
//
//    @Override
//    public Converter<?, RequestBody> requestBodyConverter(Type type,
//                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
//        return new MyResponseConverter<>(gson, type);
//    }
//
//    public static class MyResponseConverter<T> implements Converter<ResponseBody, T> {
//        private final Gson gson;
//        private final Type type;
//
//        public MyResponseConverter(Gson gson, Type type) {
//            this.gson = gson;
//            this.type = type;
//        }
//
//        @Override
//        public T convert(ResponseBody value) throws IOException {
//            String response = value.string();
//            try {
//                //ResultResponse 只解析result字段
//                BaseEntity<Object> esultResponse = gson.fromJson(response, BaseEntity.class);
//                if (TextUtils.equals("1200", esultResponse.getStatus())) {
//                    //result==1200表示成功返回，继续用本来的Model类解析
//                } else {
//                    throw new ResultException(response);
//                }
//                return gson.fromJson(response, type);
//            } finally {
//            }
//        }
//    }
//}
