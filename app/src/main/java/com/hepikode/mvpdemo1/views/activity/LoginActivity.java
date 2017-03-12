package com.hepikode.mvpdemo1.views.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hepikode.mvpdemo1.R;
import com.hepikode.mvpdemo1.presenters.LoginPresenter;
import com.hepikode.mvpdemo1.presenters.LoginPresenterImpl;
import com.hepikode.mvpdemo1.utils.IntentUtils;
import com.hepikode.mvpdemo1.views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private FirebaseAuth auth ;
    private LoginPresenter loginPresenter ;

    @BindView(R.id.progressBar)
    ProgressBar progressBar ;
    @BindView(R.id.email)
    EditText email ;
    @BindView(R.id.password)
    EditText password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance() ;
        loginPresenter = new LoginPresenterImpl(auth, this);
    }

    @OnClick(R.id.btn_login) void doLogin() {
        loginPresenter.login(email.getText().toString().trim(), password.getText().toString().trim());
    }

    @OnClick(R.id.btn_signup) void goToSignUp() {
        IntentUtils.setIntent(LoginActivity.this, SignUpActivity.class);
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Cek email dan password !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
        IntentUtils.setIntent(LoginActivity.this, HomeActivity.class);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        if (visibility)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }
}
