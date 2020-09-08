package com.example.domboscoquizmobile.models;

public class API {
    private int id;
    private String question;
    private String theme;
    private String answer;

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestions() {
        return question;
    }

    public String getTheme() {
        return theme;
    }

@Override
    public String toString()
    {
        return getTheme()+getQuestions()+getAnswer();
    }
}
