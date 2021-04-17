package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private Button wholesale, retail, custom;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wholesale = (Button) findViewById(R.id.wholesaler);
        retail = (Button) findViewById(R.id.retailer);
        custom = (Button) findViewById(R.id.customer);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, page3.class);
                startActivity(intent);

            }
        });
        retail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, retailersignup.class);
                startActivity(intent);

            }
        });
        wholesale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, wholesalersignuplogin.class);
                startActivity(intent);

            }
        });
    }

}