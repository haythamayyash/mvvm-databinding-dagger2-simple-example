package com.example.haithamayyash.simpleapp.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.haithamayyash.simpleapp.construction.PresentationRoot;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseView<B extends ViewDataBinding> extends FrameLayout {
    private final Context context;
    protected B binding;
    private PresentationRoot presentationRoot;

    public BaseView(Context context, int layoutRes) {
        super(context);
        this.context = context;
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, null
                , false);
        initView();
    }

    protected abstract View getView();

    protected abstract void initView();

    protected PresentationRoot getPresentationRoot(BaseFragment fragment) {
        if (presentationRoot == null)
            presentationRoot = new PresentationRoot(fragment);
        return presentationRoot;

    }
}
