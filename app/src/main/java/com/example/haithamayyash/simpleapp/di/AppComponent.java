package com.example.haithamayyash.simpleapp.di;

import com.example.haithamayyash.simpleapp.questions_list.QuestionListViewModel;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(QuestionListViewModel questionListViewModel);
    public PresentationComponent newPresentationComponent(PresentationModule presentationModule);
}
