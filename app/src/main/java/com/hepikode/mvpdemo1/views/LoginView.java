package com.hepikode.mvpdemo1.views;

import com.hepikode.mvpdemo1.base.BaseView;

/**
 * Created by DhytoDev on 3/7/17.
 */

public interface LoginView extends BaseView{
    void showValidationError(String message);
    void loginSuccess();
    void loginError();
    void setProgressVisibility(boolean visibility);
    void isLogin(boolean isLogin);
}