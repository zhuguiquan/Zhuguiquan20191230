package com.bw.zhuguiquan20191230.model;

import com.bw.zhuguiquan20191230.contract.IHomeContract;
import com.bw.zhuguiquan20191230.util.NetUtil;

/**
 * DateTime:2019/12/30 0030
 * author:朱贵全(Administrator)
 * function:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(final IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getJsonGet(" https://github.com/", new NetUtil.MyCallback() {
            @Override
            public void ongetJson(String string) {
                iModelCallBack.onHomeSuccess(string);
            }

            @Override
            public void ongetError(Throwable throwable) {
                iModelCallBack.onHomeFailyre(throwable);

            }
        });

    }
}
