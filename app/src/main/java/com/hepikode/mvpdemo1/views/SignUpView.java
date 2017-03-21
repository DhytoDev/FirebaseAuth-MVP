package com.hepikode.mvpdemo1.views;

import com.hepikode.mvpdemo1.base.BaseView;

/**
 * Created by DhytoDev on 3/5/17.
 */

public interface SignUpView extends BaseView {
    void showValidationError();
    void signUpSuccess();
    void signUpError();
    void setProgressVisibility(boolean visibility);
}
