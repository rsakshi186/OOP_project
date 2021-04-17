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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class page5 extends AppCompatActivity {

    private Button Singupbutton;
    private EditText inputname, inputphone, inputusername, inputpassword, inputretype;
    private ProgressDialog loadingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        Singupbutton = (Button) findViewById(R.id.signup_button);
        inputname = (EditText) findViewById(R.id.signup_name);
        inputphone = (EditText) findViewById(R.id.signup_phone_num);
        inputusername = (EditText) findViewById(R.id.signup_username);
        inputpassword = (EditText) findViewById(R.id.signup_password);
        inputretype = (EditText) findViewById(R.id.signup_retypepassword);
        loadingbar=new ProgressDialog(this);

        Singupbutton.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view)
        {
            Createaccount();
        }

    });


    }
    private void Createaccount(){
        String name=inputname.getText().toString();
        String phone=inputphone.getText().toString();
        String username=inputusername.getText().toString();
        String password=inputpassword.getText().toString();
        String repassword=inputretype.getText().toString();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this, "Field Username cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Field password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(repassword))
        {
            Toast.makeText(this, "Retype your password", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(repassword))
        {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingbar.setTitle("Create Account");
            loadingbar.setMessage("Checking user info");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            Validatephonenum(name,phone,password,username);


        }



    }
    private void Validatephonenum(String name, String phone, String password, String username)
    {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!(snapshot.child("Users").child(phone).exists()))
                {
                    HashMap<String,Object> Userdatamap=new HashMap<>();
                    Userdatamap.put("phone",phone);
                    Userdatamap.put("name",name);
                    Userdatamap.put("username",username);
                    Userdatamap.put("password",password);

                    RootRef.child("Users").child(phone).updateChildren(Userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(page5.this, "Account Created", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();
                                        Intent intent=new Intent(page5.this, page4.class);
                                        startActivity(intent);

                                    }
                                    else
                                    {
                                        loadingbar.dismiss();
                                        Toast.makeText(page5.this, "Network error occurred: Try again later...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
                else
                {
                    Toast.makeText(page5.this, "An account is already linked to this phone number", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(page5.this, "Try using another phone number", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(page5.this, page3.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
