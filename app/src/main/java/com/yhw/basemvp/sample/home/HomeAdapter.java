package com.yhw.basemvp.sample.home;

import com.yhw.basemvp.sample.R;
import com.yhw.library.adapter.BaseRecyclerAdapter;

import java.util.List;

public class HomeAdapter extends BaseRecyclerAdapter<String> {
    public HomeAdapter(List<String> dataList) {
        super(dataList);
    }

    @Override
    public int getItemLayoutId(int i) {
        return R.layout.home_item_layout;
    }

    @Override
    public void onBindViewItem(RecyclerViewHolder recyclerViewHolder, int i, String s) {
        recyclerViewHolder.setText(R.id.tv_text, s);
    }
}
