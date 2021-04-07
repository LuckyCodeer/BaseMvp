package com.yhw.basemvp.sample.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatEditText;

import com.yhw.basemvp.library.BaseActivity;
import com.yhw.basemvp.sample.R;

/**
 * 注册界面
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView, View.OnClickListener {
    private AppCompatEditText mUserNameInput;
    private AppCompatEditText mPassWordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        final Button registerBtn = findViewById(R.id.btn_register);
        mUserNameInput = findViewById(R.id.input_name);
        mPassWordInput = findViewById(R.id.input_pwd);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void onClick(View v) {
        mPresenter.doRegister(mUserNameInput.getText().toString(), mPassWordInput.getText().toString());
    }

    @Override
    public void registerSuccess() {
        showAlertDialog("恭喜你，账号注册成功！");
    }
}