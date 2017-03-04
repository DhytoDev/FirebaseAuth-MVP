package com.hepikode.mvpdemo1.view;

/**
 * Created by DhytoDev on 3/5/17.
 */

public interface SignUpView {
    void showValidationError();
    void signUpSuccess();
    void signUpError();
    void setProgressVisibility(boolean visibility);
}
