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
}
