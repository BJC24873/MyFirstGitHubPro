package com.android.demo.architecture.mvp.framework;


public interface BaseView<T extends BasePresenter> {

    public void setPresenter(T presenter);



}
