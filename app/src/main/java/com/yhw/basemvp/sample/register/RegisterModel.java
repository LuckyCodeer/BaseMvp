package com.yhw.basemvp.sample.register;

import android.os.Handler;
import android.text.TextUtils;

import com.yhw.basemvp.library.BaseModel;

public class RegisterModel extends BaseModel {
    private final Handler mHandler = new Handler();

    /**
     * 模拟网络注册
     */
    public void doRegister(String userName, String password, RegisterListener registerListener) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            mHandler.postDelayed(() -> {
                registerListener.onFail("用户名密码不能为空");
            }, 3000);
            return;
        }
        mHandler.post(registerListener::onSuccess);
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
    }

    public interface RegisterListener {
        void onSuccess();

        void onFail(String errorMsg);
    }
}
