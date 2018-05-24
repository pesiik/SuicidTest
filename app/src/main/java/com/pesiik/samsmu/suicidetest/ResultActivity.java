package com.pesiik.samsmu.suicidetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pesiik.samsmu.suicidetest.model.UserManager;

public class ResultActivity extends AppCompatActivity {

    private TextView mResultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultTextView = (TextView) findViewById(R.id.result_text_view);
        String name = UserManager.get(getApplicationContext()).getCurrentUser().getName() + ",";
        String text = name + getString(R.string.hight_suicide_level);
        mResultTextView.setText(text);
    }
}
