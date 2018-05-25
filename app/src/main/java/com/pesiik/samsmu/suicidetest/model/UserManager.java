package com.pesiik.samsmu.suicidetest.model;

import android.content.Context;

public class UserManager {

    private static UserManager sUserManager;

    private Context mContext;
    private User mCurrentUser;

    public static UserManager get(Context context){
        if(sUserManager == null){
            sUserManager = new UserManager(context);
        }
        return sUserManager;
    }

    private UserManager(Context context){
        mContext = context;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public void setCurrentUser(User currentUser) {
        mCurrentUser = currentUser;
    }

    public double calculatePSRResult(){
        double result = 0;
        double adaptValue = 0, escapismValue =0, depressionValue = 0;
        for(Question question : QuestionLab.get(mContext).getQuestions()){
            if(question.getType() == Question.Type.adaptability){
                adaptValue += question.getAnswerPosition();
            }
            if(question.getType() == Question.Type.escapism){
                escapismValue += question.getAnswerPosition();
            }
            if(question.getType() == Question.Type.depression){
                depressionValue += question.getAnswerPosition();
            }
        }
        mCurrentUser.setAdaptiveValue(adaptValue);
        mCurrentUser.setEscapismValue(escapismValue);
        mCurrentUser.setDepressionValue(depressionValue);
        result = mCurrentUser.getPSRValue();
        return result;
    }
}
