package com.improve10x.quizbee;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizBeeApi {

    public QuizBeeApiService createQuizBeeApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuizBeeApiService quizBeeApiService = retrofit.create(QuizBeeApiService.class);
        return quizBeeApiService;
    }
}
