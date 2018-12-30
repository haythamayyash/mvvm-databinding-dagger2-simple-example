package com.example.haithamayyash.simpleapp.questions_list;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.haithamayyash.simpleapp.R;
import com.example.haithamayyash.simpleapp.base.BaseView;
import com.example.haithamayyash.simpleapp.databinding.QuestionListLayoutBinding;
import com.example.haithamayyash.simpleapp.questions_list.adapter.QuestionListAdapter;

public class QuestionListView extends BaseView<QuestionListLayoutBinding> {
    private QuestionListFragment fragment;

    public QuestionListView(Fragment fragment) {
        super(fragment.getContext(), R.layout.question_list_layout);
        this.fragment = (QuestionListFragment) fragment;
        prepareView();
    }

    @Override
    public View getView() {
        return binding.getRoot();
    }

    @Override
    public void initView() {

    }

    void prepareView() {
        QuestionListViewModel questionListViewModel = getPresentationRoot(fragment).getQuestionListViewModel();
        questionListViewModel.getQuestionListLiveData().observe(fragment, questionResponse -> {
            binding.progressbar.setVisibility(GONE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(fragment.getContext()
                    , LinearLayoutManager.VERTICAL, false);
            QuestionListAdapter questionListAdapter = new QuestionListAdapter(fragment.getContext(), questionResponse.getQuestions());
            binding.recyclerViewQuestionList.setAdapter(questionListAdapter);
            binding.recyclerViewQuestionList.setLayoutManager(layoutManager);
        });

        questionListViewModel.getNetworkErrorLiveData().observe(fragment, isNetworkError -> {
            binding.progressbar.setVisibility(GONE);
            Snackbar.make(binding.coordinatorLayout,"Network Error",Snackbar.LENGTH_LONG)
            .show();
        });
    }
}
