package com.fmi.bot;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.pm.Signature;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    private Button joinApp;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    public void init() {
        joinApp = findViewById(R.id.join);
    }

    public void redirectJoinApp() {
        joinApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinApp.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        printKEYHASH();
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //AccessToken.setCurrentAccessToken(null);
                Intent intent = new Intent(getApplicationContext(), JoinApp.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                //  info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                // info.setText("Login attempt failed.");
            }
        });


        init();
        redirectJoinApp();
    }

//        private void printKEYHASH(){
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo("com.fmi.bot", PackageManager.GET_SIGNATURES);
//            for(Signature signature:info.signatures){
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KEyHAsh", Base64.encodeToString(md.digest(),Base64.DEFAULT));
//
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode , resultCode , data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}