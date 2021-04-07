package com.yhw.basemvp.sample.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.yhw.basemvp.library.BaseActivity;
import com.yhw.basemvp.sample.R;
import com.yhw.basemvp.sample.login.LoginActivity;
import com.yhw.basemvp.sample.register.RegisterActivity;

/**
 * MVP模式示例代码
 * <p>
 * MVP 即 Model-View-Presenter
 * MVP由MVC（Model-View-Controller）演变而来，相比MVC解耦性更强，模块职责划分明显，层次清晰，使得代码更易维护
 * Model负责提供数据，View负责UI显示， Presenter负责逻辑处理，View和Model交互的中间纽带
 * <p>
 * model层主要负责：
 * <p>
 * · 从网络，数据库，文件，传感器，第三方等数据源读写数据。
 * <p>
 * · 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
 * <p>
 * · 对数据的临时存储,管理，协调上层数据请求。
 * <p>
 * view层主要负责：
 * <p>
 * · 提供UI交互
 * <p>
 * · 在presenter的控制下修改UI。
 * <p>
 * · 将业务事件交由presenter处理。
 * <p>
 * presenter层主要负责:
 * 作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。Presenter包含了根据用户在视图中的行为去更新模型的逻辑。
 * 视图仅仅只是将用户的行为告知Presenter，而Presenter负责从视图中取得数据然后发送给模型。
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        final Button loginBtn = findViewById(R.id.btn_login);
        final Button registerBtn = findViewById(R.id.btn_register);
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.toLogin();
                break;
            case R.id.btn_register:
                mPresenter.toRegister();
                break;
        }
    }

    @Override
    public void toLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void toRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.model) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES ?
                    AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
        }
        return super.onOptionsItemSelected(item);
    }
}