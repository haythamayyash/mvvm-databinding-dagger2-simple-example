package com.example.haithamayyash.simpleapp.questions_list;

import android.view.View;

import com.example.haithamayyash.simpleapp.base.BaseFragment;

import javax.inject.Inject;

public class QuestionListFragment extends BaseFragment {
    @Inject
    QuestionListView questionListView;

    @Override
    public View bindView() {
        return questionListView.getView();
    }

    @Override
    protected void initDI() {
        getPresentationComponent(this).inject(this);
    }
}
