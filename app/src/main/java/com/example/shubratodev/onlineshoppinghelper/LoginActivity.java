package com.example.shubratodev.onlineshoppinghelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText e5,e6;
    Button b2,b3;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b2 = (Button)findViewById(R.id.login);
        b3 = (Button)findViewById(R.id.signup);
        b3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        }));
        db = new DatabaseHelper(this);
        e5 = (EditText)findViewById(R.id.lemail);
        e6 = (EditText)findViewById(R.id.lpassword);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email = e5.getText().toString();
               String password = e6.getText().toString();
               Boolean chkemailpass = db.emailpassword(email,password);
               if(chkemailpass==true)
               {
                   Intent login = new Intent(LoginActivity.this,RecyclerActivity.class);
                   startActivity(login);
                   Toast.makeText(getApplicationContext(),"Successfully Login!",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(getApplicationContext(),"Wrong email id and password!!",Toast.LENGTH_SHORT).show();
               }
            }

        });


    }
}
