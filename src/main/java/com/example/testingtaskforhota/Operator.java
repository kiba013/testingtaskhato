package com.example.testingtaskforhota;

import org.springframework.stereotype.Component;

public class Operator {


    private String text;
    private String answer;

    public Operator(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public Operator() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "text='" + text + '\'' +
                '}';
    }
}
