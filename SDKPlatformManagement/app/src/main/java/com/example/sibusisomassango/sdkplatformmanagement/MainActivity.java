package com.example.sibusisomassango.sdkplatformmanagement;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sibusisomassango.sdkplatformmanagement.utils.ValidateEmail;
import com.example.sibusisomassango.sdkplatformmanagement.utils.ValidatePassword;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnSignIn;
    private EditText txtEmailAddress;
    private EditText txtPassword;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        txtEmailAddress =(EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        error = (TextView) findViewById(R.id.error);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailAddress = txtEmailAddress.getText().toString();
                String password = txtPassword.getText().toString();

               if(isValidEmailAddress(emailAddress) && isValidPassword(password)){
                   Intent fragmentIntent = new Intent(getApplicationContext(),FragmentActivity.class);
                   fragmentIntent.putExtra("INTENT_TYPE","signIn");
                   startActivity(fragmentIntent);
               }else{
                   error.setText("Username/password combination is not valid");
               }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fragmentIntent = new Intent(getApplicationContext(),FragmentActivity.class);
                fragmentIntent.putExtra("INTENT_TYPE","signUp");
                startActivity(fragmentIntent);
            }
        });
    }

    private boolean isValidPassword(String password) {
        boolean isValidPassword =false;
        ValidatePassword isValidPasswordCheck = new ValidatePassword(password);
        if(isValidPasswordCheck.isValidPassword()){
            isValidPassword = true;
        }
        return isValidPassword;
    }

    public boolean isValidEmailAddress(String emailAddress){
        boolean isValidEmail = false;
        ValidateEmail emailCheck = new ValidateEmail(emailAddress);
        if(emailCheck.validateEmailAddress()){
            isValidEmail = true;
        }
        return isValidEmail;
    }


}
