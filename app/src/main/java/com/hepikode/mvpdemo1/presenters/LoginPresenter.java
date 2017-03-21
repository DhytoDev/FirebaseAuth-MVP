package com.hepikode.mvpdemo1.presenters;

import android.app.Activity;
import android.content.Context;

import com.hepikode.mvpdemo1.base.BasePresenter;
import com.hepikode.mvpdemo1.views.LoginView;

/**
 * Created by DhytoDev on 3/7/17.
 */

public interface LoginPresenter extends BasePresenter<LoginView> {
    void login(String email, String password);
    void checkLogin();
}
