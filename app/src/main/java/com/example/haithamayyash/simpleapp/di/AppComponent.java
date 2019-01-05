package com.example.haithamayyash.simpleapp.di;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    public PresentationComponent newPresentationComponent(PresentationModule presentationModule);
}
