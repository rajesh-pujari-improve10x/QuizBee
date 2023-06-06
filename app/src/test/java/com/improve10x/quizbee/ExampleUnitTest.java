package com.improve10x.quizbee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.quizbee.model.Quiz;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getQuizData() throws IOException {
        QuizBeeApiService quizBeeApiService = new QuizBeeApi().createQuizBeeApiService();
        Call<List<Quiz>> call = quizBeeApiService.fetchData();
        List<Quiz> quizs = call.execute().body();
        assertNotNull(quizs);
        assertFalse(quizs.isEmpty());
        System.out.println(new Gson().toJson(quizs));
    }
}