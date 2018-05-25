package com.pesiik.samsmu.suicidetest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pesiik.samsmu.suicidetest.model.User;
import com.pesiik.samsmu.suicidetest.model.UserManager;

public class ResultActivity extends AppCompatActivity {

    private TextView mResultTextView;
    private User mUser;
    private double mPsrValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mUser = UserManager.get(getApplicationContext()).getCurrentUser();

        mPsrValue = UserManager.get(getApplicationContext()).calculatePSRResult();

        mResultTextView = (TextView) findViewById(R.id.result_text_view);
        String name = UserManager.get(getApplicationContext()).getCurrentUser().getName() + ",";
        String text = name + getRightMessage();

        mResultTextView.setText(text);
    }

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, ResultActivity.class);

        return intent;
    }

    private String getRightMessage(){
        int roundedPsr = (int) Math.round(mPsrValue);
        String message = "";

        if(roundedPsr <= 11){
            message = getString(R.string.small_suicide_level);
        } else if(mPsrValue <= 21){
            message = getString(R.string.mid_suicide_level);
        } else{
            message = getString(R.string.hight_suicide_level);
        }
        return message;
    }

}
