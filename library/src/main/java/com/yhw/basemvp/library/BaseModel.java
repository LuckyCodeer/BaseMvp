package com.yhw.basemvp.library;

/**
 * 基类model
 */
public abstract class BaseModel {

    /**
     * 销毁方法 用于取消网络请求，释放资源等操作
     */
    public abstract void onDestroy();
}
