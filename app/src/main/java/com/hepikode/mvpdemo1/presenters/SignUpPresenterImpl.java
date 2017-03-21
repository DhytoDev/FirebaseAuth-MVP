package com.hepikode.mvpdemo1.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hepikode.mvpdemo1.views.SignUpView;

/**
 * Created by DhytoDev on 3/5/17.
 */

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpView signUpView ;
    private FirebaseAuth auth ;

    public SignUpPresenterImpl(FirebaseAuth auth) {
        this.auth = auth ;
    }

    @Override
    public void signUp(String email, String password) {
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ) {
            signUpView.showValidationError();
        } else {

            signUpView.setProgressVisibility(true);
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener((Activity) signUpView, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            signUpView.setProgressVisibility(false);

                            if (!task.isSuccessful()) {
                                signUpView.signUpError();
                            } else {
                                signUpView.signUpSuccess();
                            }
                        }
                    });
        }
    }

    @Override
    public void attachView(SignUpView view) {
        signUpView = view ;
    }

    @Override
    public void detachView() {
        signUpView = null ;
    }
}
