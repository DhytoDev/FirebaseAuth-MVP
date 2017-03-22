package com.hepikode.mvpdemo1.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hepikode.mvpdemo1.utils.Utils;
import com.hepikode.mvpdemo1.views.HomeView;
import com.hepikode.mvpdemo1.views.activity.LoginActivity;

/**
 * Created by DhytoDev on 3/21/17.
 */

public class HomePresenterImpl implements HomePresenter {

    private FirebaseAuth auth ;
    private FirebaseAuth.AuthStateListener authListener ;
    private HomeView homeView ;
    private Activity context ;

    public HomePresenterImpl(FirebaseAuth auth, final Activity context) {
        this.auth = auth;
        this.context = context ;

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser() ;

                if (user == null) {
                    Utils.setIntent(context, LoginActivity.class);
                    context.finish();
                }
            }
        };
    }

    @Override
    public void getCurrentUser() {
        if (auth.getCurrentUser() != null)
            homeView.setUser(auth.getCurrentUser());

    }

    @Override
    public void signOut() {
        auth.signOut();
    }

    @Override
    public void onStart() {
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        auth.removeAuthStateListener(authListener);
    }

    @Override
    public void attachView(HomeView view) {
        homeView = view ;
    }

    @Override
    public void detachView() {
        homeView = null ;
    }
}
