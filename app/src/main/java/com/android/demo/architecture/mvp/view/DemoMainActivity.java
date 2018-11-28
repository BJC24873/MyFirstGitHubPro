package com.android.demo.architecture.mvp.view;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


import com.android.demo.R;

import com.android.demo.architecture.mvp.presenter.IRandomNumberPresenter;
import com.android.demo.architecture.mvp.presenter.RandomNumberPresenter;

public class DemoMainActivity  extends Activity implements IRandomNumberView, View.OnClickListener{
    
    private TextView mRandomNumTextView = null;
    private IRandomNumberPresenter mRandomNumberPresenter = null;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.mvp_mian_activity_layout);
        mRandomNumberPresenter = new RandomNumberPresenter(this);
        mRandomNumTextView = (TextView)findViewById(R.id.random_num);
        mRandomNumTextView.setOnClickListener(this);
    }

    @Override
    public void onRandomNumberGenerate(int num) {
        mRandomNumTextView.setText(String.valueOf(num));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.random_num :
                if(mRandomNumberPresenter != null) {
                    mRandomNumberPresenter.getRandomNumber();
                }
            break;
            default :
            break;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mRandomNumberPresenter != null) {
            mRandomNumberPresenter.onDestroy();
        }
        mRandomNumberPresenter = null;
    }
}
