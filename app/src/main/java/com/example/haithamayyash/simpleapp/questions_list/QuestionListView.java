package com.example.haithamayyash.simpleapp.questions_list;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.haithamayyash.simpleapp.R;
import com.example.haithamayyash.simpleapp.base.BaseFragment;
import com.example.haithamayyash.simpleapp.base.BaseView;
import com.example.haithamayyash.simpleapp.databinding.QuestionListLayoutBinding;
import com.example.haithamayyash.simpleapp.questions_list.adapter.QuestionListAdapter;

import javax.inject.Inject;

public class QuestionListView extends BaseView<QuestionListLayoutBinding> {

    @Inject
    QuestionListViewModel questionListViewModel;

    public QuestionListView(BaseFragment fragment) {
        super(fragment, R.layout.question_list_layout);
    }

    @Override
    public View getView() {
        return binding.getRoot();
    }

    @Override
    public void initView() {
        questionListViewModel.getQuestionListLiveData().observe(fragment, questionResponse -> {
            binding.progressbar.setVisibility(GONE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(fragment.getContext()
                    , LinearLayoutManager.VERTICAL, false);
            QuestionListAdapter questionListAdapter = new QuestionListAdapter(fragment.getContext()
                    , questionResponse.getQuestions());
            binding.recyclerViewQuestionList.setAdapter(questionListAdapter);
            binding.recyclerViewQuestionList.setLayoutManager(layoutManager);
        });

        questionListViewModel.getNetworkErrorLiveData().observe(fragment, isNetworkError -> {
            binding.progressbar.setVisibility(GONE);
            Snackbar.make(binding.coordinatorLayout, "Network Error", Snackbar.LENGTH_LONG)
                    .show();
        });
    }

    @Override
    protected void initDI() {
        getPresentationComponent(this).inject(this);
    }

}
