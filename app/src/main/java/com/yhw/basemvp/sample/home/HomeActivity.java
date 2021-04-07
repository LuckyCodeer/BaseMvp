package com.yhw.basemvp.sample.home;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.yhw.basemvp.library.BaseActivity;
import com.yhw.basemvp.sample.R;
import com.yhw.library.adapter.BaseRecyclerAdapter;

import java.util.List;

/**
 * 主页
 */
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeView ,
        BaseRecyclerAdapter.OnItemLongClickListener {
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.loadHomeList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }


    @Override
    public void displayList(List<String> list) {
        mHomeAdapter = new HomeAdapter(list);
        mHomeAdapter.setOnItemLongClickListener(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void removeItem(int position) {
        mHomeAdapter.removeAt(position);
    }

    @Override
    public void onItemLongClick(int i, View view) {
        final Dialog dialog = new AlertDialog.Builder(this)
                .setItems(new String[]{"删除"}, (dialog1, which) -> {
                    mPresenter.deleteItem(i);
                })
                .create();
        dialog.show();
    }
}