package com.example.shubratodev.onlineshoppinghelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prg =(ProgressBar) findViewById(R.id.progressBar);
        prg.setMax(3);
        prg.setProgress(0);
        final Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    for (int i=0;i<3;i++)
                    {
                        prg.setProgress(i);
                        sleep(3000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        myThread.start();
    }
}
