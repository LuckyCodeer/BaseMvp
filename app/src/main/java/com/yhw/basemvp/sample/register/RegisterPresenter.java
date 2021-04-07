package com.yhw.basemvp.sample.register;

import com.yhw.basemvp.library.BasePresenter;

public class RegisterPresenter extends BasePresenter<RegisterModel, RegisterView> {

    @Override
    public RegisterModel getModel() {
        return new RegisterModel();
    }

    public void doRegister(String userName, String password) {
        mView.showLoading();
        mModel.doRegister(userName, password, new RegisterModel.RegisterListener() {
            @Override
            public void onSuccess() {
                mView.hideLoading();
                mView.registerSuccess();
            }

            @Override
            public void onFail(String errorMsg) {
                mView.hideLoading();
                mView.showToast(errorMsg);
            }
        });
    }
}
