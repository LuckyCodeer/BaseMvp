package com.yhw.basemvp.library;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * presenter通用接口
 *
 * @param <V> view
 */
public interface IPresenter<V extends IView> extends LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    default void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    default void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    default void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    default void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    default void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    default void onAny() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    default void onDestroy() {
    }

    /**
     * 加载view
     *
     * @param view view
     */
    void attachView(V view);

    /**
     * 获取view
     *
     * @return view
     */
    V getView();

}
