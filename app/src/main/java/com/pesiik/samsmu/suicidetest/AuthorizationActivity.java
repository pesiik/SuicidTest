package com.pesiik.samsmu.suicidetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AuthorizationActivity extends AppCompatActivity implements AgePickerFragment.OnSelectedAgeListener{

    private Button mAgeButton;
    private Button mAccessButton;

    private static final String DIALOG_AGE = "DialogAge";

    private static final int REQUEST_AGE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        mAgeButton = (Button) findViewById(R.id.age_button);
        mAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AgePickerFragment dialog = AgePickerFragment.newInstance(14);
                dialog.show(fragmentManager, DIALOG_AGE);
            }
        });

        mAccessButton = (Button) findViewById(R.id.access_button);
        mAccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = QuestionPagerActivity.newIntent(getApplicationContext(), 0);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPositiveClick(int number) {
        mAgeButton.setText(String.valueOf(number));
    }
}
