package com.example.haithamayyash.simpleapp.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.haithamayyash.simpleapp.app_util.ApiInterface;
import com.example.haithamayyash.simpleapp.base.BaseFragment;
import com.example.haithamayyash.simpleapp.base.BaseView;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListFragment;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListView;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {
    private BaseFragment fragment;
    private BaseView view;

    public PresentationModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public PresentationModule(BaseView view) {
        this.view = view;
    }

    @Provides
    public BaseFragment getFragment() {
        return fragment;
    }

    @Provides
    public QuestionListView getQuestionListView() {
        return new QuestionListView(fragment);
    }

    @Provides
    public QuestionListViewModel getQuestionListViewModel(ApiInterface apiInterface) {
        return new QuestionListViewModel(apiInterface);
    }
}
