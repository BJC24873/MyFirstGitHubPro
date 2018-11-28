package com.android.demo.architecture.mvp.increase.data.source;

import com.android.demo.architecture.mvp.framework.BaseRepository;
import com.android.demo.architecture.mvp.increase.domain.usecase.GetIncrease;


public interface IncreaseDataContract {

    public interface Repository extends BaseRepository{
        GetIncrease.ResponseValue getIncrease(GetIncrease.RequestValues requestValues);
    }




}