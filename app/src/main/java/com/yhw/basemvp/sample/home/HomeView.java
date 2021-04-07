package com.yhw.basemvp.sample.home;

import com.yhw.basemvp.library.IView;

import java.util.List;

public interface HomeView extends IView {

    void displayList(List<String> list);

    void removeItem(int position);

}
