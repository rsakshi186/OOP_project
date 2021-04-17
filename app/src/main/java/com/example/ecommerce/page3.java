package com.example.ecommerce;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class page3 extends AppCompatActivity {

    private Button newherebutton, signinbutton;
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        newherebutton = (Button) findViewById(R.id.signup);
        signinbutton = (Button) findViewById(R.id.signin);
        newherebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(page3.this, singuppage.class);
                startActivity(intent);

            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(page3.this, page4.class);
                startActivity(intent);

            }
        });
    }
}