package com.example.haithamayyash.simpleapp.construction;

import com.example.haithamayyash.simpleapp.app_util.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.haithamayyash.simpleapp.app_util.Constant.BASE_URL;

public class AppRoot {
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    public Retrofit getRetrofit(){
        if(retrofit == null)
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public ApiInterface getApiInterface(){
        if(apiInterface == null)
            apiInterface = getRetrofit().create(ApiInterface.class);
        return apiInterface;
    }
}
