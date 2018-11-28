package com.android.demo.architecture.mvp.increase.domain.usecase;

import com.android.demo.architecture.mvp.increase.data.source.IncreaseRepository;
import com.android.demo.architecture.mvp.framework.UseCase;

public class GetIncrease extends UseCase<GetIncrease.RequestValues, GetIncrease.ResponseValue>{

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        IncreaseRepository in =  new IncreaseRepository();
        in.getIncrease(requestValues).getmRondNum();
        getUseCaseCallback().onSuccess(in.getIncrease(requestValues));



    }

    public static class RequestValues implements UseCase.RequestValues{

        private int mRondNum = -1;

        public void setmRondNum(int num) {
            this.mRondNum = num;

        }


        public int getmRondNum() {
            return mRondNum;
        }



    
    }

    public static class ResponseValue implements UseCase.ResponseValue {
        private int mRondNum = -1;

        public void setmRondNum(int num) {
            this.mRondNum = num;

        }


        public int getmRondNum() {
            return mRondNum;
        }
    }

}