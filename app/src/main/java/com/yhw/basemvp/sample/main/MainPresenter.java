package com.yhw.basemvp.sample.main;

import com.yhw.basemvp.library.BasePresenter;

public class MainPresenter extends BasePresenter<MainModel, MainView> {

    @Override
    public MainModel getModel() {
        return new MainModel();
    }

    public void toLogin() {
        getView().toLogin();
    }

    public void toRegister() {
        getView().toRegister();
    }
}
