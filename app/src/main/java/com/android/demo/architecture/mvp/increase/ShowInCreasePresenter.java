package com.android.demo.architecture.mvp.increase;

import com.android.demo.architecture.mvp.framework.UseCase;
import com.android.demo.architecture.mvp.framework.UseCaseHandler;
import com.android.demo.architecture.mvp.increase.domain.usecase.GetIncrease;

public class ShowInCreasePresenter implements IncreaseContract.Presenter{

    private UseCaseHandler mUseCaseHandler;
    private IncreaseContract.View mIncreaseView;
    private GetIncrease mIncrease;


    public ShowInCreasePresenter(UseCaseHandler handle, 
            IncreaseContract.View view, GetIncrease usecase) {
        mUseCaseHandler = handle;
        mIncreaseView = view;
        mIncrease = usecase;
        mIncreaseView.setPresenter(this);
    }


    @Override
    public void start() {
        //getIncease();
    }

    @Override
    public void getIncease() {
        GetIncrease.RequestValues re = new GetIncrease.RequestValues();
        re.setmRondNum(50);
        mUseCaseHandler.execute(mIncrease, re, new UseCase.UseCaseCallback<GetIncrease.ResponseValue>(){
            @Override
            public void onSuccess(GetIncrease.ResponseValue response){
                if(mIncreaseView == null || response == null) {
                    return;
                }else if(!mIncreaseView.isActive()) {
                    return;
                }
                mIncreaseView.showInCrease(response.getmRondNum());
            }
            @Override
            public void onError(){

            }
        });

    }


}
