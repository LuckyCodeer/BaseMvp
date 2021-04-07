package com.yhw.basemvp.sample.login;

import com.yhw.basemvp.library.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    @Override
    public LoginModel getModel() {
        return new LoginModel();
    }

    public void doLogin(String userName, String password) {
        getView().showLoading();
        mModel.doLogin(userName, password, new LoginModel.LoginListener() {
            @Override
            public void onSuccess() {
                mView.hideLoading();
                mView.loginSuccess();
            }

            @Override
            public void onFail(String errorMsg) {
                mView.hideLoading();
                mView.showToast(errorMsg);
            }
        });
    }

}
