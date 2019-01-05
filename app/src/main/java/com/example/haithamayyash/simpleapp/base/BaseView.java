package com.example.haithamayyash.simpleapp.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.haithamayyash.simpleapp.App;
import com.example.haithamayyash.simpleapp.di.PresentationComponent;
import com.example.haithamayyash.simpleapp.di.PresentationModule;

import java.util.Objects;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseView<B extends ViewDataBinding> extends FrameLayout {
    protected final Activity context;
    protected B binding;
    protected BaseFragment fragment;

    public BaseView(BaseFragment fragment, int layoutRes) {
        super(Objects.requireNonNull(fragment.getContext()));
        this.fragment = fragment;
        context = fragment.getActivity();
        initDI();
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, null
                , false);
        initView();
    }

    protected abstract View getView();

    protected abstract void initView();

    protected PresentationComponent getPresentationComponent(BaseView view) {
        App app = (App) context.getApplication();
        return app.getAppComponent().newPresentationComponent(new PresentationModule(view));
    }

    protected abstract void initDI();
}
