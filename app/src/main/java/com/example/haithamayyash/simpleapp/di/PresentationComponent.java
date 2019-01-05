package com.example.haithamayyash.simpleapp.di;

import com.example.haithamayyash.simpleapp.questions_list.QuestionListFragment;
import com.example.haithamayyash.simpleapp.questions_list.QuestionListView;

import dagger.Subcomponent;

@Subcomponent(modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(QuestionListFragment questionListFragment);
    void inject(QuestionListView questionListView);
}
