package com.yhw.basemvp.sample.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatEditText;

import com.yhw.basemvp.library.BaseActivity;
import com.yhw.basemvp.sample.R;
import com.yhw.basemvp.sample.home.HomeActivity;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView, View.OnClickListener {
    private AppCompatEditText mUserNameInput;
    private AppCompatEditText mPassWordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        final Button loginBtn = findViewById(R.id.btn_login);
        mUserNameInput = findViewById(R.id.input_name);
        mPassWordInput = findViewById(R.id.input_pwd);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess() {
        showToast("登录成功！");
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        mPresenter.doLogin(mUserNameInput.getText().toString(), mPassWordInput.getText().toString());
    }
}