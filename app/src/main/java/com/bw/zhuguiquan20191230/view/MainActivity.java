package com.bw.zhuguiquan20191230.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.zhuguiquan20191230.R;
import com.bw.zhuguiquan20191230.base.BaseActivity;
import com.bw.zhuguiquan20191230.contract.IHomeContract;
import com.bw.zhuguiquan20191230.presenter.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {


    private TextView textView;

    @Override
    protected void initData() {
        mpresenter.getHomeData();

    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.tv);

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomeSuccess(String str) {
        textView.setText(str);

    }

    @Override
    public void onHomeFailyre(Throwable throwable) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();

    }
}
