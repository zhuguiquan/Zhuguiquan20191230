package com.bw.zhuguiquan20191230.presenter;

import com.bw.zhuguiquan20191230.base.BasePresenter;
import com.bw.zhuguiquan20191230.contract.IHomeContract;
import com.bw.zhuguiquan20191230.model.HomeModel;

/**
 * DateTime:2019/12/30 0030
 * author:朱贵全(Administrator)
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView>implements IHomeContract.IPresenter{

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomeContract.IModel.IModelCallBack() {
            @Override
            public void onHomeSuccess(String str) {
                view.onHomeSuccess(str);
            }

            @Override
            public void onHomeFailyre(Throwable throwable) {
                view.onHomeFailyre(throwable);

            }
        });

    }
}
