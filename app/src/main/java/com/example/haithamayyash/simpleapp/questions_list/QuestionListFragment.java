package com.example.haithamayyash.simpleapp.questions_list;

import android.view.View;

import com.example.haithamayyash.simpleapp.base.BaseFragment;

public class QuestionListFragment extends BaseFragment {
    QuestionListView questionListView;
    @Override
    public View bindView() {
        questionListView = getQuestionListRoot(this).getQuestionListView();
        return questionListView.getView();
    }
}
