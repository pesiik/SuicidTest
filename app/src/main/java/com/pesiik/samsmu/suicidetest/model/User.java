package com.pesiik.samsmu.suicidetest.model;

public class User {

    private String mName;
    private int mAge;
    private Sex mSex;

    public User(String name, int age, Sex sex){
        mName = name;
        mAge = age;
        mSex = sex;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public Sex getSex() {
        return mSex;
    }

    public void setSex(Sex sex) {
        mSex = sex;
    }


    public enum Sex{
        male,
        female
    }

}
