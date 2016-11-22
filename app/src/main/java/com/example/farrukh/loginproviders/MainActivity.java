package com.example.farrukh.loginproviders;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private TextView email , name ;
    private Button login,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getApplication());


        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.textView2);
        name = (TextView) findViewById(R.id.textView3);
        login = (Button) findViewById(R.id.button2);
        logout = (Button) findViewById(R.id.button3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            logout.setVisibility(View.VISIBLE);
            email.setText(user.getEmail());
            name.setText(user.getDisplayName());
        }
        else
        {
            logout.setVisibility(View.INVISIBLE);
        }

    }
}
