package com.yhw.basemvp.library;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

/**
 * 基类Fragment
 * 其它Fragment继承此Fragment
 *
 * @param <P> presenter
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {
    protected P mPresenter;
    private ProgressDialog mProgressDialog;
    private Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(getLayoutId(), container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = new ProgressDialog(getContext());
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
        mToast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public void showAlertDialog(String msg) {
        final Dialog dialog = new AlertDialog.Builder(getContext())
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
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            getLifecycle().removeObserver(mPresenter);
        }
    }

    public abstract P getPresenter();

    public abstract int getLayoutId();

    public abstract void initView(View rootView);
}
