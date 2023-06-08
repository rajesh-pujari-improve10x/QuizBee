package com.improve10x.quizbee.questionsscreen;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.quizbee.BaseActivity;
import com.improve10x.quizbee.OnItemActionListener;
import com.improve10x.quizbee.databinding.ActivityQuestionsBinding;
import com.improve10x.quizbee.model.Question;
import com.improve10x.quizbee.model.Quiz;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends BaseActivity {
    
    private ActivityQuestionsBinding binding;

    private QuestionsAdapter questionsAdapter;

    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchQuestionsData();
        setupQuestionsAdapter();
        setupQuestionNumsRv();
    }

    private void setupQuestionNumsRv() {
        binding.questionNumsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.questionNumsRv.setAdapter(questionsAdapter);
    }

    private void setupQuestionsAdapter() {
        questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setData(new ArrayList<>());
        questionsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(Question question) {
                showQuestionData(question);
            }
        });
    }

    private void fetchQuestionsData() {
        Call<List<Quiz>> call = quizBeeApiService.fetchData();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                questions = response.body().get(0).getQuestions();
                questionsAdapter.setData(questions);
                showQuestionData(questions.get(0));
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionsActivity.this, "Failed to Load Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showQuestionData(Question question) {
        binding.questionTxt.setText(question.getQuestion());
        binding.firstAnsRb.setText(question.getAnswers().get(0));
        binding.secAnsRb.setText(question.getAnswers().get(1));
        binding.thirdAnsRb.setText(question.getAnswers().get(2));
        binding.fourthAnsRb.setText(question.getAnswers().get(3));
    }
}