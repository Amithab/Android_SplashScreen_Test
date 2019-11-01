package com.example.androiddocstut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;


public class SplashTest extends AppCompatActivity {

    private static final int STOPSPLASH = 0;
    //time in milliseconds
    private static final long SPLASHTIME = 3000;

    private ImageView splash;

    //handler for splash screen
    private Handler splashHandler = new Handler() {
        /* (non-Javadoc)
         * @see android.os.Handler#handleMessage(android.os.Message)
         */
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    //remove SplashScreen from view
                    splash.setVisibility(View.GONE);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_test);
        splash = findViewById(R.id.splashscreen);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        //splashHandler.sendMessageDelayed(msg, SPLASHTIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashTest.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }
}


