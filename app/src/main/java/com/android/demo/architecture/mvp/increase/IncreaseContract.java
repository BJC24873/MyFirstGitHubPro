package com.android.demo.architecture.mvp.increase;

import com.android.demo.architecture.mvp.framework.BasePresenter;
import com.android.demo.architecture.mvp.framework.BaseView;

public interface IncreaseContract {


    public interface View extends BaseView<Presenter> {
        public void showInCrease(int num);

        public boolean isActive();

    }

    public interface Presenter extends BasePresenter{
        public void getIncease();

    }



}