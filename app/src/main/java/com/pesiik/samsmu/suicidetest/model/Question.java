package com.pesiik.samsmu.suicidetest.model;

public class Question {


    private String mText;
    private boolean mIsSevenAnswers;
    private boolean hasAnswer;
    private int answerPosition;
    private Type mType;

    public Question(String text, boolean isSixAnswers, Type type) {
        mText = text;
        mIsSevenAnswers = isSixAnswers;
        mType = type;
        hasAnswer = false;
        answerPosition = -1;
    }



    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public boolean isSevenAnswers() {
        return mIsSevenAnswers;
    }

    public void setSevenAnswers(boolean sevenAnswers) {
        mIsSevenAnswers = sevenAnswers;
    }

    public boolean isHasAnswer() {
        return hasAnswer;
    }

    public void setHasAnswer(boolean hasAnswer) {
        this.hasAnswer = hasAnswer;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public enum Type{
        adaptability,
        escapism,
        depression,
        none

    }
}
