package com.pesiik.samsmu.suicidetest.model;

public class User {

    private String mName;
    private int mAge;
    private Sex mSex;

    private double mAdaptiveValue;
    private double mEscapismValue;
    private double mDepressionValue;

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

    public double getAdaptiveValue() {
        return mAdaptiveValue;
    }

    public void setAdaptiveValue(double adaptiveValue) {
        mAdaptiveValue = adaptiveValue;
    }

    public double getEscapismValue() {
        return mEscapismValue;
    }

    public void setEscapismValue(double escapismValue) {
        mEscapismValue = escapismValue;
    }

    public double getDepressionValue() {
        return mDepressionValue;
    }

    public void setDepressionValue(double depressionValue) {
        mDepressionValue = depressionValue;
    }

    public double getPSRValue(){
        double psr = -0.294f * getAdaptiveValue() + 0.084 * getEscapismValue() + 0.552 * getDepressionValue() + 30.666f;
        return psr;
    }

    public enum Sex{
        male,
        female
    }

}
