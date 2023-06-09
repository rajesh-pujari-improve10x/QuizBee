package com.improve10x.quizbee.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Question {

    private Integer number;

    private String question;

    private ArrayList<String> answers;

    @SerializedName("correct_answer")
    private Integer correctAnswer;
}
