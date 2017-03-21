package com.hepikode.mvpdemo1.presenters;

import com.hepikode.mvpdemo1.base.BasePresenter;
import com.hepikode.mvpdemo1.views.HomeView;

/**
 * Created by DhytoDev on 3/21/17.
 */

public interface HomePresenter extends BasePresenter<HomeView> {
    void getCurrentUser();
    void signOut();
    void onStart();
    void onStop();
}
