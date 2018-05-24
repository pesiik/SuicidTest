package com.pesiik.samsmu.suicidetest.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Arrays;
import java.util.List;

public class QuestionLab {
    private static QuestionLab sQuestionLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private List<Question> mQuestions;

    public static QuestionLab get(Context context){
        if(sQuestionLab == null){
            sQuestionLab = new QuestionLab(context);
        }
        return sQuestionLab;
    }

    private QuestionLab(Context context){
        mContext = context;
        mQuestions = testData();
    }

    public Question getQuestion(int position){
        return mQuestions.get(position);
    }

    private List<Question> testData(){
        List<Question> questions = Arrays.asList(
        new Question("Испытываете неловкость, когда вступаете с кем-нибудь в разговор?", true),
        new Question("Нет желания раскрываться перед другими?", true),
        new Question("Во всем любите состязание, соревнование, борьбу?", true),
        new Question("Предъявляете к себе высокие требования?", true),
        new Question("Часто ругаете себя за сделанное?", true),
        new Question("Часто чувствуете себя униженным?", true),
        new Question("Сомневаетесь, что можете нравиться кому-нибудь из лиц противоположного пола?", true),
        new Question("Свои обещания выполняете всегда?", true),
        new Question("Тепло, добро отнситесь с окружающими?", true),
        new Question("Держитесь от всех чуть в стороне?", true),
        new Question("В своих неудачах вините себя?", true),
        new Question("Вы Человек ответственный, на вас можно положиться?", true),

        new Question("Снижение интереса и удовольствия к привычным для Вас событиям и действиям?", false),
        new Question("Чувство опустошенности , безнадежности, ухудшения настроения?", false),
        new Question("Проблемы со сном: бессонница или, наоборот, Вы слишком много спали?",false),
        new Question("Вы чувствовали усталость или испытывали недостаток энергии?",false),
        new Question("Снижение или повышение аппетита?", false),
        new Question("Вы испытывали чувство неудовлетворенности собой – или думали о том," +
                " что Вы неудачник, или что подводите себя или свою семью?", false));

        return questions;
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }
}
