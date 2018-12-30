package com.example.haithamayyash.simpleapp.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.haithamayyash.simpleapp.construction.AppRoot;

public class BaseViewModel extends ViewModel {
    private AppRoot appRoot;
    protected MutableLiveData<Boolean> networkErrorLiveData;

    public LiveData<Boolean> getNetworkErrorLiveData() {
        if (networkErrorLiveData == null)
            networkErrorLiveData = new MutableLiveData<>();
        return networkErrorLiveData;
    }

    protected AppRoot getAppRoot() {
        if (appRoot == null)
            appRoot = new AppRoot();
        return appRoot;
    }
}
