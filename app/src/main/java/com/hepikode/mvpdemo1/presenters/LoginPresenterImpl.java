package com.hepikode.mvpdemo1.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hepikode.mvpdemo1.views.LoginView;

/**
 * Created by DhytoDev on 3/7/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private FirebaseAuth auth ;
    private LoginView loginView ;

    public LoginPresenterImpl(FirebaseAuth auth, LoginView loginView) {
        this.auth = auth;
        this.loginView = loginView;
    }
    @Override
    public void login(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            loginView.showValidationError();
        } else {
            loginView.setProgressVisibility(true);

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener((Activity) loginView, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            loginView.setProgressVisibility(false);
                            if(!task.isSuccessful()) {
                                loginView.loginError();
                            } else {
                                loginView.loginSuccess();
                            }
                        }
                    });
        }
    }
}
