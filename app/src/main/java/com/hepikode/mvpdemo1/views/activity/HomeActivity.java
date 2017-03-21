package com.hepikode.mvpdemo1.views.activity;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hepikode.mvpdemo1.R;
import com.hepikode.mvpdemo1.base.BaseActivity;
import com.hepikode.mvpdemo1.models.User;
import com.hepikode.mvpdemo1.presenters.HomePresenterImpl;
import com.hepikode.mvpdemo1.views.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeView {

    private FirebaseAuth auth ;
    private HomePresenterImpl homePresenter ;

    @BindView(R.id.email_text)
    EditText emailText ;
    @BindView(R.id.username_text)
    EditText usernameText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance() ;

        homePresenter = new HomePresenterImpl(auth, this);

        homePresenter.attachView(this);
        homePresenter.getCurrentUser() ;
    }

    @OnClick(R.id.sign_out_button) void signOutClick() {
        homePresenter.signOut();
    }

    @Override
    protected void onStart() {
        super.onStart();
        homePresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        homePresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.detachView();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setEnabled(boolean isEnabled) {

    }

    @Override
    public void setUser(FirebaseUser user) {
        emailText.setText(user.getEmail());
        usernameText.setText(user.getDisplayName());
    }
}
