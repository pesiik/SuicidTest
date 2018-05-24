package com.pesiik.samsmu.suicidetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pesiik.samsmu.suicidetest.model.User;
import com.pesiik.samsmu.suicidetest.model.UserManager;

public class AuthorizationActivity extends AppCompatActivity implements AgePickerFragment.OnSelectedAgeListener{

    private Button mAgeButton;
    private Button mAccessButton;
    private RadioGroup mSexGroup;
    private EditText mNameEditText;

    private static final int defaultAge = 14;
    private User mUser;

    private static final String DIALOG_AGE = "DialogAge";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        mUser = new User("", -1, null);

        UserManager.get(getApplicationContext()).setCurrentUser(mUser);

        mNameEditText = (EditText) findViewById(R.id.name_edit);
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAgeButton = (Button) findViewById(R.id.age_button);
        mAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                int age = defaultAge;
                if(mUser.getAge() >= 14)
                {
                    age = mUser.getAge();
                }
                AgePickerFragment dialog = AgePickerFragment.newInstance(age);
                dialog.show(fragmentManager, DIALOG_AGE);
            }
        });

        mSexGroup = (RadioGroup) findViewById(R.id.sex_radio_button_group);
        mSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.female){
                    mUser.setSex(User.Sex.female);
                }
                if(checkedId == R.id.male){
                    mUser.setSex(User.Sex.male);
                }
            }
        });

        mAccessButton = (Button) findViewById(R.id.access_button);
        mAccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUser.getName() != "" && mUser.getAge() >= 14 && mUser.getSex() != null)
                {
                    Intent intent = QuestionPagerActivity.newIntent(getApplicationContext(), 0);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),R.string.empty_fields_hint, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onPositiveClick(int number) {
        mAgeButton.setText(String.valueOf(number));
        mUser.setAge(number);
    }
}
