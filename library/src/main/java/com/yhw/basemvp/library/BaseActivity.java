package com.yhw.basemvp.library;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MVP基类Activity
 * 其它Activity继承此Activity
 *
 * @param <P> presenter
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;
    private ProgressDialog mProgressDialog;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
            mPresenter.attachView(this);
        }
        setContentView(getLayoutId());
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract P getPresenter();

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("请稍后...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public void showAlertDialog(String msg) {
        final Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage(msg)
                .setPositiveButton("确定", (dialog1, which) -> {
                })
                .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void showAlertDialog(int msgId) {
        showAlertDialog(getString(msgId));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            getLifecycle().removeObserver(mPresenter);
        }
    }

}