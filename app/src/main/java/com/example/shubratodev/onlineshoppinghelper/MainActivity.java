package com.example.shubratodev.onlineshoppinghelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3,e4;
    Button b1,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.Name);
        e2=(EditText)findViewById(R.id.Email);
        e3=(EditText)findViewById(R.id.Password);
        e4=(EditText)findViewById(R.id.CPassword);
        b1=(Button)findViewById(R.id.Register);
        b4=(Button)findViewById(R.id.Backlogin);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s3.equals(s4))
                    {
                      Boolean chkmail = db.chkmail(s2);
                      if(chkmail==true)
                      {
                          Boolean insert = db.insert(s1,s2,s3);
                          if(insert==true)
                          {
                              Toast.makeText(getApplicationContext(),"Registration Successful!",Toast.LENGTH_SHORT).show();
                          }
                      }
                      else{
                          Toast.makeText(getApplicationContext(),"Email already Exists!",Toast.LENGTH_SHORT).show();
                      }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
