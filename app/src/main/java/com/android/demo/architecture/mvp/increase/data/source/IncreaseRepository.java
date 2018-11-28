
package com.android.demo.architecture.mvp.increase.data.source;

import java.util.Random;

import com.android.demo.architecture.mvp.increase.domain.usecase.GetIncrease;

public class IncreaseRepository implements IncreaseDataContract.Repository{

    private Random mRandom = null;

    @Override
    public void start() {
        if(mRandom == null) {
            mRandom = new Random();
        }
    }

    @Override
    public GetIncrease.ResponseValue getIncrease(GetIncrease.RequestValues requestValues) {
        if(mRandom == null) {
            mRandom = new Random();
        }
        GetIncrease.ResponseValue responseValue =  new GetIncrease.ResponseValue();
        responseValue.setmRondNum(mRandom.nextInt(requestValues.getmRondNum()));
        return responseValue;
    }

}


