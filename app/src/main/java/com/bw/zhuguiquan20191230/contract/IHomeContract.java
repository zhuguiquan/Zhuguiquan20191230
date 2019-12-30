package com.bw.zhuguiquan20191230.contract;

/**
 * DateTime:2019/12/30 0030
 * author:朱贵全(Administrator)
 * function:
 */
public interface IHomeContract {
    interface IView{
        void onHomeSuccess(String str);
        void onHomeFailyre(Throwable throwable);

    }
    interface IPresenter{
        void getHomeData();

    }
    interface IModel{
        void getHomeData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onHomeSuccess(String str);
            void onHomeFailyre(Throwable throwable);

        }
    }
}
