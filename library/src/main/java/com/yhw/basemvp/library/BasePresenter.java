package com.yhw.basemvp.library;

/**
 * 基类presenter
 *
 * @param <M> model
 * @param <V> view
 */
public abstract class BasePresenter<M extends BaseModel, V extends IView> implements IPresenter<V> {
    protected V mView;
    protected M mModel;

    public abstract M getModel();

    public BasePresenter() {
        mModel = getModel();
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void onDestroy() {
        mView = null;
        if (mModel != null) {
            mModel.onDestroy();
        }
    }

}
