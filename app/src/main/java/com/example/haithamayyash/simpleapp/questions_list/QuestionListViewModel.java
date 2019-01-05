package com.example.haithamayyash.simpleapp.questions_list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.haithamayyash.simpleapp.App;
import com.example.haithamayyash.simpleapp.app_util.ApiInterface;
import com.example.haithamayyash.simpleapp.base.BaseViewModel;
import com.example.haithamayyash.simpleapp.di.AppModule;
import com.example.haithamayyash.simpleapp.di.DaggerAppComponent;
import com.example.haithamayyash.simpleapp.questions_list.model.QuestionResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionListViewModel extends BaseViewModel {
    private MutableLiveData<QuestionResponse> questionListLiveData;

    @Inject
    ApiInterface apiInterface;

    public QuestionListViewModel(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public LiveData<QuestionResponse> getQuestionListLiveData() {
        if (questionListLiveData == null) {
            questionListLiveData = new MutableLiveData<>();
            loadQuestionList();
        }
        return questionListLiveData;
    }

    private void loadQuestionList() {
        apiInterface.getQuestionList().enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(@NonNull Call<QuestionResponse> call, Response<QuestionResponse> response) {
                questionListLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<QuestionResponse> call, Throwable t) {
                networkErrorLiveData.postValue(true);
            }
        });
    }
}
