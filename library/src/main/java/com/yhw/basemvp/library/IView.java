package com.yhw.basemvp.library;

/**
 * View通用接口
 */
public interface IView {
    void showLoading();

    void hideLoading();

    void showToast(int resId);

    void showToast(String msg);

    void showAlertDialog(String msg);

    void showAlertDialog(int msgId);
}
