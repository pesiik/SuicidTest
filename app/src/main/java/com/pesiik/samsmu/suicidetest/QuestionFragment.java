package com.pesiik.samsmu.suicidetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pesiik.samsmu.suicidetest.model.Question;
import com.pesiik.samsmu.suicidetest.model.QuestionLab;

import java.util.List;

public class QuestionFragment extends Fragment {

    private static final String ARG_QUESTION_POSITION = "question_position";
    private static final String ARG_ANSWER = "answer";

    private Question mQuestion;
    private TextView mTextQuestion;
    private TextView mNumberQuestion;
    private Button mEndButton;
    private int mPosition;
    private RadioGroup mAnswersGroup;

    public static QuestionFragment newInstance(int position){
        Bundle args = new Bundle();
        args.putInt(ARG_QUESTION_POSITION, position);

        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initializeCurrentQuestion(){
        mPosition = getArguments().getInt(ARG_QUESTION_POSITION);
        mQuestion = QuestionLab.get(getContext()).getQuestion(mPosition);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeCurrentQuestion();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initializeCurrentQuestion();
        int layout = 0;
        if(mQuestion.isSevenAnswers()){
            layout = R.layout.fragment_question_seven;
        }
        else {
            layout = R.layout.fragment_question_four;
        }
        View v = inflater.inflate(layout, container, false);
        mTextQuestion = (TextView) v.findViewById(R.id.question_text);
        mTextQuestion.setText(mQuestion.getText());

        mNumberQuestion = (TextView) v.findViewById(R.id.question_number);
        String numberString = getString(R.string.question_number, mPosition+1);
        mNumberQuestion.setText(numberString);


        mAnswersGroup = (RadioGroup) v.findViewById(R.id.answer_radio_group);

        mAnswersGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton button = (RadioButton) mAnswersGroup.findViewById(checkedId);
                int index = mAnswersGroup.indexOfChild(button);

                mQuestion.setHasAnswer(true);
                mQuestion.setAnswerPosition(index);

                checkEnableEndButton();

            }
        });

        mEndButton = (Button) v.findViewById(R.id.end_test_button);
        mEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultActivity.class);
                startActivity(intent);
            }
        });

        checkEnableEndButton();
        return v;
    }


    private void checkEnableEndButton(){
        boolean isEnabled = true;
        List<Question> questions = QuestionLab.get(getContext()).getQuestions();
        for(Question question : questions){
            if(!question.isHasAnswer()){
                isEnabled = false;
                break;
            }
        }
        mEndButton.setEnabled(isEnabled);
    }
}
