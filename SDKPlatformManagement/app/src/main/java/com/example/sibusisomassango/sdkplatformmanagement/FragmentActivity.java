package com.example.sibusisomassango.sdkplatformmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if(savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_frame, new SignUpFragment()).commit();
        }
    }
}
