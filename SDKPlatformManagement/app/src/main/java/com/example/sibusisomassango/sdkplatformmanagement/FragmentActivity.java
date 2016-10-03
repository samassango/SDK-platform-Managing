package com.example.sibusisomassango.sdkplatformmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Intent intent = getIntent();
        if(savedInstanceState ==null) {
            if(intent.getStringExtra("INTENT_TYPE").equals("signUp")){
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_frame, new SignUpFragment()).commit();
            }else{
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_frame, new SignInFragment()).commit();
            }

        }
    }
}
