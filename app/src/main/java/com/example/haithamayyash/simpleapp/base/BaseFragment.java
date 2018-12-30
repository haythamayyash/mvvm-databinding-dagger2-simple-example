package com.example.haithamayyash.simpleapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haithamayyash.simpleapp.construction.PresentationRoot;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListFragment;

public abstract class BaseFragment extends Fragment {
    protected PresentationRoot questionListRoot;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return bindView();
    }

    public abstract View bindView();

    protected PresentationRoot getQuestionListRoot(QuestionListFragment fragment){
        if(questionListRoot == null)
            questionListRoot = new PresentationRoot(fragment);
        return questionListRoot;
    }
}
