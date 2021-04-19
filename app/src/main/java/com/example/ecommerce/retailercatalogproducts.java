package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class retailercatalogproducts extends AppCompatActivity {
    private ImageView breads, veggies;
    private ImageView dairy, spices;
    private ImageView chips, cookies;
    private ImageView canned;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailercatalogproducts);

        breads = (ImageView) findViewById(R.id.bread);
        veggies = (ImageView) findViewById(R.id.veggie);
        dairy = (ImageView) findViewById(R.id.dairy);
        spices = (ImageView) findViewById(R.id.spices);
        chips = (ImageView) findViewById(R.id.chips);
        cookies = (ImageView) findViewById(R.id.cookies);
        canned=(ImageView) findViewById(R.id.canned);


        breads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","breads");
                startActivity(intent);

            }
        });
        veggies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","veggies");
                startActivity(intent);

            }
        });
        dairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","dairy");
                startActivity(intent);

            }
        });
        spices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","spices");
                startActivity(intent);

            }
        });
        chips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","chips");
                startActivity(intent);

            }
        });
        cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","cookies");
                startActivity(intent);

            }
        });
        canned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(retailercatalogproducts.this, retailer_add_product.class);
                intent.putExtra( "Category","canned");
                startActivity(intent);

            }
        });


    }
}