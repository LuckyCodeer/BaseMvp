package com.yhw.basemvp.sample.home;

import android.os.Handler;

import com.yhw.basemvp.library.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class HomeModel extends BaseModel {
    private final Handler mHandler = new Handler();
    private final List<String> list = new ArrayList<>();

    /**
     * 模拟网络加载数据
     */
    public void loadHomeList(LoadListener loadListener) {
        mHandler.postDelayed(() -> {
            list.clear();
            for (int i = 0; i < 100; i++) {
                list.add("测试数据" + i);
            }
            loadListener.onSuccess(list);
        }, 2000);
    }

    /**
     * 模拟网络删除数据
     * @param i 索引
     */
    public void deleteItem(int i, LoadListener loadListener) {
        mHandler.postDelayed(() -> {
            loadListener.onSuccess(list);
        }, 2000);
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
    }

    public interface LoadListener {
        void onSuccess(List<String> list);
    }
}
