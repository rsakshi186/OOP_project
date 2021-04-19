package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class retaileraddproducts extends AppCompatActivity {
private String categoryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retaileraddproducts);
        categoryname = getIntent().getExtras().get("Category").toString();
        Toast.makeText(this, categoryname, Toast.LENGTH_SHORT).show();
    }
}