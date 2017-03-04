package com.hepikode.mvpdemo1.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hepikode.mvpdemo1.R;
import com.hepikode.mvpdemo1.presenter.SignUpPresenterImp;
import com.hepikode.mvpdemo1.view.SignUpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar ;
    @BindView(R.id.email)
    EditText email ;
    @BindView(R.id.password)
    EditText password ;

    private SignUpPresenterImp signUpPresenter ;

    private FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance() ;

        signUpPresenter = new SignUpPresenterImp(auth, this);


    }

    @OnClick(R.id.sign_up_button) void submit() {
        signUpPresenter.signUp(email.getText().toString().trim(), password.getText().toString().trim());
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Cek email dan password !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "SignUp Sukses !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpError() {
        Toast.makeText(this, "SignUp Gagal !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        if (visibility)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);

    }
}
