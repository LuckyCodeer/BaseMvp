package com.yhw.basemvp.sample.home;

import com.yhw.basemvp.library.BasePresenter;

public class HomePresenter extends BasePresenter<HomeModel, HomeView> {
    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    public void loadHomeList() {
        mView.showLoading();
        mModel.loadHomeList(list -> {
            mView.hideLoading();
            mView.displayList(list);
        });
    }

    public void deleteItem(int position) {
        mView.showLoading();
        mModel.deleteItem(position, list -> {
            mView.hideLoading();
            mView.removeItem(position);
            mView.showToast("删除成功");
        });
    }
}
