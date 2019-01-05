package com.example.haithamayyash.simpleapp;

import android.app.Application;

import com.example.haithamayyash.simpleapp.di.AppComponent;
import com.example.haithamayyash.simpleapp.di.AppModule;
import com.example.haithamayyash.simpleapp.di.DaggerAppComponent;

public class App extends Application {
   private  AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
