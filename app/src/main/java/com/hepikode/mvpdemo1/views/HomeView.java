package com.hepikode.mvpdemo1.views;

import com.google.firebase.auth.FirebaseUser;
import com.hepikode.mvpdemo1.base.BaseView;

/**
 * Created by DhytoDev on 3/21/17.
 */

public interface HomeView extends BaseView {
    void setEnabled(boolean isEnabled);
    void setUser(FirebaseUser user);
}
