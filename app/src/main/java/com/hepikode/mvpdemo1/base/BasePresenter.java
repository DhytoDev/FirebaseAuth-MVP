package com.hepikode.mvpdemo1.base;

/**
 * Created by DhytoDev on 3/21/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
