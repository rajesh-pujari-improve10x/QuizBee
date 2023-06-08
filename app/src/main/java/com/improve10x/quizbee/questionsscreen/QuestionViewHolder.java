package com.improve10x.quizbee.questionsscreen;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.quizbee.databinding.QuestionItemBinding;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    QuestionItemBinding binding;

    public QuestionViewHolder(QuestionItemBinding questionItemBinding) {
        super(questionItemBinding.getRoot());
        binding = questionItemBinding;
    }
}
