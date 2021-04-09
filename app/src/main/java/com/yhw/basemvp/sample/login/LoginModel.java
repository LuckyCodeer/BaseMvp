package com.yhw.basemvp.sample.login;

import android.os.Handler;
import android.text.TextUtils;

import com.yhw.basemvp.library.BaseModel;

public class LoginModel extends BaseModel {
    private final Handler mHandler = new Handler();

    /**
     * 模拟网络登录
     */
    public void doLogin(String userName, String password, LoginListener loginListener) {
        mHandler.postDelayed(() -> {
            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                loginListener.onFail("用户名密码不能为空");
                return;
            }
            loginListener.onSuccess();
        }, 3000);
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
    }

    public interface LoginListener {
        void onSuccess();

        void onFail(String errorMsg);
    }
}
