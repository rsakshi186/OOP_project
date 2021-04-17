package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wholesalersignuplogin extends AppCompatActivity {
    private Button newherebutton, signinbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesalersignuplogin);
        newherebutton = (Button) findViewById(R.id.wholesaler_signup);
        signinbutton = (Button) findViewById(R.id.wholesaler_signin);
        newherebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wholesalersignuplogin.this, wholesalersignup.class);
                startActivity(intent);

            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wholesalersignuplogin.this, wholesalerslogin.class);
                startActivity(intent);

            }
        });
    }
}