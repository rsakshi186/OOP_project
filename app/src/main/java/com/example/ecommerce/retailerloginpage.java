package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerce.model.Users;
import com.example.ecommerce.model2.Retailers;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class retailerloginpage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText edtPhone, edtOTP;
    private EditText inputusername, inputpassword;
    // buttons for generating OTP and verifying OTP
    private Button verifyOTPBtn, generateOTPBtn;
    private ProgressDialog loadingbar;
    // string for storing our verification ID
    private String verificationId;
    private String ParentDbname2 = "Retailers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailerloginpage);
        mAuth = FirebaseAuth.getInstance();
        edtPhone = findViewById(R.id.retailer_login_ph_num);
        edtOTP = findViewById(R.id.retailer_login_enter_otp);
        verifyOTPBtn = findViewById(R.id.retailer_login_verify_and_signin);
        generateOTPBtn = findViewById(R.id.retailer_login_generate_otp);
        inputusername = (EditText) findViewById(R.id.retailer_login_username);
        inputpassword = (EditText) findViewById(R.id.retailer_login_password);
        loadingbar = new ProgressDialog(this);


        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loginuser();
            }
        });

    }

    private void Loginuser() {
        String username = inputusername.getText().toString();
        String password = inputpassword.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        } else {
            loadingbar.setTitle("Login");
            loadingbar.setMessage("Checking user credentials");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            access(password, username);


        }
    }

    private void access(String password, String username) {
        final DatabaseReference RootRefretailer;
        RootRefretailer = FirebaseDatabase.getInstance().getReference();
        RootRefretailer.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(ParentDbname2).child(username).exists()) {
                    Retailers retailersdata = snapshot.child(ParentDbname2).child(username).getValue(Retailers.class);
                    if (retailersdata.getUsername().equals(username)) {
                        if (retailersdata.getPassword().equals(password)) {
                            Toast.makeText(retailerloginpage.this, "Logged in succesfully", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();
                            Intent intent = new Intent(retailerloginpage.this, retailercatalogproducts.class);
                            startActivity(intent);
                        }
                    }
                } else {
                    Toast.makeText(retailerloginpage.this, "Incorrect login credentials", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}

