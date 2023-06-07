package com.improve10x.quizbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.quizbee.databinding.ActivityQuizBeeHomeBinding;

public class QuizBeeHomeActivity extends AppCompatActivity {

    ActivityQuizBeeHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBeeHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleStartBtn();
    }

    private void handleStartBtn() {
        binding.startBtn.setOnClickListener(v -> {
            if (binding.nameTxt.getText().toString().trim().equals("") == false) {
                Intent intent = new Intent(QuizBeeHomeActivity.this,
                        QuestionsActivity.class);
                startActivity(intent);
            }
        });
    }
}