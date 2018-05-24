package com.pesiik.samsmu.suicidetest.model;

public class Question {


    private String mText;
    private boolean mIsSevenAnswers;
    private boolean hasAnswer;
    private int answerPosition;

    public Question(String text, boolean isSixAnswers) {
        mText = text;
        mIsSevenAnswers = isSixAnswers;
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
}
