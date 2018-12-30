package com.example.haithamayyash.simpleapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.haithamayyash.simpleapp.questions_list.QuestionListFragment;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        QuestionListFragment questionListFragment = new QuestionListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, questionListFragment).commit();
    }
}
