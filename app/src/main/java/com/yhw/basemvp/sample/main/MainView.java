package com.yhw.basemvp.sample.main;

import com.yhw.basemvp.library.IView;

public interface MainView extends IView {

    /**
     * 跳转到登录
     */
    void toLogin();

    /**
     * 跳转到注册
     */
    void toRegister();
}
