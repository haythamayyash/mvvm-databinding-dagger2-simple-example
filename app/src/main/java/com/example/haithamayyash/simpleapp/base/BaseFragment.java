package com.example.haithamayyash.simpleapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haithamayyash.simpleapp.App;
import com.example.haithamayyash.simpleapp.di.PresentationComponent;
import com.example.haithamayyash.simpleapp.di.PresentationModule;

import java.util.Objects;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDI();
        return bindView();
    }

    public abstract View bindView();

    protected PresentationComponent getPresentationComponent(BaseFragment fragment) {
        return ((App) Objects.requireNonNull(getActivity()).getApplication()).getAppComponent()
                .newPresentationComponent(new PresentationModule(fragment));
    }

    protected abstract void initDI();
}
