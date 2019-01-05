package com.example.haithamayyash.simpleapp.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<Boolean> networkErrorLiveData;

    public LiveData<Boolean> getNetworkErrorLiveData() {
        if (networkErrorLiveData == null)
            networkErrorLiveData = new MutableLiveData<>();
        return networkErrorLiveData;
    }

}
