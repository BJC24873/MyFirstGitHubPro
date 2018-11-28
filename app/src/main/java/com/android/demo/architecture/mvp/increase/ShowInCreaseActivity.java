package com.android.demo.architecture.mvp.increase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.demo.R;
import com.android.demo.architecture.mvp.framework.UseCaseHandler;
import com.android.demo.architecture.mvp.increase.domain.usecase.GetIncrease;

public class ShowInCreaseActivity  extends Activity implements IncreaseContract.View, View.OnClickListener{
    private TextView mRandomNumTextView;
    private IncreaseContract.Presenter mShowInCreasePresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mvp_mian_activity_layout);
        mRandomNumTextView = (TextView)findViewById(R.id.random_num);
        mRandomNumTextView.setOnClickListener(this);
        init();
    }

    private void init() {
        //UseCaseHandler hanlder = UseCaseHandler.getInstance();
        new ShowInCreasePresenter(UseCaseHandler.getInstance(), 
            this, new GetIncrease());

    }


//-----------interface--------------//
    @Override
    public void onClick(View view) {
        if(mShowInCreasePresenter != null) {
            mShowInCreasePresenter.getIncease();
        }
        
    }
    @Override
    public void setPresenter(IncreaseContract.Presenter presenter) {
        mShowInCreasePresenter = presenter;

    }

    @Override
    public void showInCrease(int num) {
        if(mRandomNumTextView == null) {
            return;
        }
        mRandomNumTextView.setText(String.valueOf(num));
    }

    @Override
    public boolean isActive() {
        return !isFinishing() || !isDestroyed();
    }

    
}