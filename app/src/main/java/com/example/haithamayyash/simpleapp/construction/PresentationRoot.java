package com.example.haithamayyash.simpleapp.construction;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import com.example.haithamayyash.simpleapp.base.BaseFragment;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListView;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListViewModel;

public class PresentationRoot {
    private final Fragment fragment;

    public PresentationRoot(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public QuestionListView getQuestionListView() {
        return new QuestionListView(fragment);
    }

    public QuestionListViewModel getQuestionListViewModel() {
        return new QuestionListViewModel();
    }

}
