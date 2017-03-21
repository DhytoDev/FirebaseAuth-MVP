package com.hepikode.mvpdemo1.presenters;

import com.hepikode.mvpdemo1.base.BasePresenter;
import com.hepikode.mvpdemo1.views.SignUpView;

/**
 * Created by DhytoDev on 3/5/17.
 */

public interface SignUpPresenter extends BasePresenter<SignUpView> {
    void signUp(String email, String password);
}
