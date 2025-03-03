package com.example.demomovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView developerText = findViewById(R.id.developer_text);

        // Fade In Animation
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000); // 2 seconds
        developerText.startAnimation(fadeIn);

        // Delay ke baad MainActivity open karo
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000); // 3 seconds delay
    }
}