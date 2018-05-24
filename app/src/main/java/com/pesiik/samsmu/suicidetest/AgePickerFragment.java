package com.pesiik.samsmu.suicidetest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class AgePickerFragment extends DialogFragment {

    private static final String ARG_AGE = "age";


    private OnSelectedAgeListener mCallback;

    private NumberPicker mAgePicker;

    public static AgePickerFragment newInstance(int number){
        Bundle args = new Bundle();
        args.putInt(ARG_AGE, number);

        AgePickerFragment fragment = new AgePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnSelectedAgeListener{
        public void onPositiveClick(int number);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int age = getArguments().getInt(ARG_AGE);

        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_age, null);

        mAgePicker = (NumberPicker) v.findViewById(R.id.dialog_age_picker);
        mAgePicker.setMinValue(14);
        mAgePicker.setMaxValue(70);
        if(age >= mAgePicker.getMinValue()){
            mAgePicker.setValue(age);
        }

        return new AlertDialog.Builder(getContext())
                .setView(v).setTitle(R.string.age_button)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCallback.onPositiveClick(mAgePicker.getValue());
                    }
                }).create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnSelectedAgeListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }
}
