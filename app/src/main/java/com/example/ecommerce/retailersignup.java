package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class retailersignup extends AppCompatActivity {
    private Button newherebutton, signinbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailersignup);
        newherebutton = (Button) findViewById(R.id.retailer_signup);
        signinbutton = (Button) findViewById(R.id.retailer_signin);

        newherebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailersignup.this, retailer_signuppage.class);
                startActivity(intent);

            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(retailersignup.this, retailerloginpage.class);
                startActivity(intent);

            }
        });
    }
}