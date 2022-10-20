package com.example.myapplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Api myApi;
//    private final static String BASE_URL = "https://random-data-api.com/api/v2/";
    private final static String BASE_URL = "https://gorest.co.in/public/v2/";
    private final String API_KEY = "Bearer 9888a5e748cc605d5e5a24c11644f94b5ee15c2a9435774fe0ac6cbe3a2aef15";

    private RetrofitClient(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", API_KEY).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }
    public Api getMyApi(){
        return myApi;
    }

}
