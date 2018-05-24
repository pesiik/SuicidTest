package com.pesiik.samsmu.suicidetest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pesiik.samsmu.suicidetest.model.Question;
import com.pesiik.samsmu.suicidetest.model.QuestionLab;

import java.util.List;

public class QuestionPagerActivity extends AppCompatActivity {

    protected static final String EXTRA_QUESTION_POSITION = "com.pesiik.samsmu.suicidetest.question_position";

    private ViewPager mViewPager;
    private List<Question> mQuestions;

    public static Intent newIntent(Context packageContext, int position){
        Intent intent = new Intent(packageContext, QuestionPagerActivity.class);
        intent.putExtra(EXTRA_QUESTION_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pager);

        int position = getIntent().getIntExtra(EXTRA_QUESTION_POSITION, 0);

        mViewPager = (ViewPager) findViewById(R.id.question_view_pager);
        mQuestions = QuestionLab.get(this).getQuestions();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return QuestionFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return mQuestions.size();
            }
        });

        mViewPager.setCurrentItem(position);
    }





}
