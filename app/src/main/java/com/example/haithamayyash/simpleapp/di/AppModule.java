package com.example.haithamayyash.simpleapp.di;

import android.app.Application;

import com.example.haithamayyash.simpleapp.app_util.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.haithamayyash.simpleapp.app_util.Constant.BASE_URL;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    ApiInterface getApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
