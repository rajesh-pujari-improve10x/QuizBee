package com.improve10x.quizbee.questionsscreen;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.quizbee.OnItemActionListener;
import com.improve10x.quizbee.databinding.QuestionItemBinding;
import com.improve10x.quizbee.model.Question;
import com.improve10x.quizbee.model.Quiz;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

    private List<Question> questions;

    private OnItemActionListener onItemActionListener;

    int selectedQuestionPosition = 0;

    void setData(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemBinding binding = QuestionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(binding);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Question question = questions.get(position);
        holder.binding.questionNumTxt.setText(String.valueOf(position + 1));
        holder.binding.getRoot().setOnClickListener(v -> {
            selectedQuestionPosition = position;
            notifyDataSetChanged();
            onItemActionListener.onClick(question);
        });
        if (selectedQuestionPosition == position) {
            holder.binding.questionNumTxt.setTextColor(Color.parseColor("#F44336"));
        } else {
            holder.binding.questionNumTxt.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
