package com.hepikode.mvpdemo1.views;

/**
 * Created by DhytoDev on 3/7/17.
 */

public interface LoginView {
    void showValidationError();
    void loginSuccess();
    void loginError();
    void setProgressVisibility(boolean visibility);
}
