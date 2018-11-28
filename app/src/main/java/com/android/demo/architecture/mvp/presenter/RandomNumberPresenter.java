package com.android.demo.architecture.mvp.presenter;


import com.android.demo.architecture.mvp.view.IRandomNumberView;
import com.android.demo.architecture.mvp.model.RandomNumber;

public class RandomNumberPresenter implements IRandomNumberPresenter{
    
    IRandomNumberView mRandomNumberView;
    RandomNumber mRandomNumber;
    
    public RandomNumberPresenter(IRandomNumberView view) {
        mRandomNumberView = view;
        init();
    }
    
    
    private void init() {
        mRandomNumber = new RandomNumber();
    }
    
    @Override
    public int getRandomNumber() {
        mRandomNumberView.onRandomNumberGenerate(mRandomNumber.createRandomNumber());
        return 1;
    }
    
    @Override
    public void onDestroy() {
        //todo
        mRandomNumberView = null;
    }
}
