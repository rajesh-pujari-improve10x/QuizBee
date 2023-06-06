package com.improve10x.quizbee.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Quiz {

    @SerializedName("_id")
    private String id;

    private Module module;

    private ArrayList<Question> questions;
}
