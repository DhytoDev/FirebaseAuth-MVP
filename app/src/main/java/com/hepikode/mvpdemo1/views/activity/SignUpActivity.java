package com.hepikode.mvpdemo1.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.hepikode.mvpdemo1.R;
import com.hepikode.mvpdemo1.base.BaseActivity;
import com.hepikode.mvpdemo1.presenters.SignUpPresenterImpl;
import com.hepikode.mvpdemo1.utils.Utils;
import com.hepikode.mvpdemo1.views.SignUpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUpView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar ;
    @BindView(R.id.email)
    EditText email ;
    @BindView(R.id.password)
    EditText password ;

    private SignUpPresenterImpl signUpPresenter ;

    private FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance() ;

        signUpPresenter = new SignUpPresenterImpl(auth);
        signUpPresenter.attachView(this);
    }

    @OnClick(R.id.sign_up_button) void onSignUpButtonClick() {
        signUpPresenter.signUp(email.getText().toString().trim(), password.getText().toString().trim());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signUpPresenter.detachView();
    }

    @Override
    public void showValidationError() {
        Utils.showMessage(this, "Cek email dan password");
    }

    @Override
    public void signUpSuccess() {
        Utils.showMessage(this, "Signup Sukses !");
        Utils.setIntent(this, LoginActivity.class);
    }

    @Override
    public void signUpError() {
        Utils.showMessage(this, "SignUp Gagal !");
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        if (visibility)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);

    }

    @Override
    public Context getContext() {
        return this;
    }
}
