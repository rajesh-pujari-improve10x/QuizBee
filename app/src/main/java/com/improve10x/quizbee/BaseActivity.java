package com.improve10x.quizbee;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected QuizBeeApiService quizBeeApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupNetworkMethods();
    }

    private void setupNetworkMethods() {
        QuizBeeApi quizBeeApi = new QuizBeeApi();
        quizBeeApiService = quizBeeApi.createQuizBeeApiService();
    }
}
