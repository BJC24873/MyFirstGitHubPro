
package com.android.demo.architecture.mvp.model;


import java.util.Random;

public class RandomNumber {

    Random mRandom = null;
    public RandomNumber() {
        mRandom = new Random();
    }

    public int createRandomNumber() {
        return mRandom.nextInt(100);        
    }

}
