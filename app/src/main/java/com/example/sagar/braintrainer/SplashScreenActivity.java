package com.example.sagar.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mProgressbar = findViewById(R.id.splash_screen_progress_bar);

        Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        });

        myThread.start();

    }

    private void doWork(){

        for (int progress = 0; progress <= 100; progress += 20){

            try {
                Thread.sleep(500);
                mProgressbar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp(){

        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);

        startActivity(intent);
    }
}

