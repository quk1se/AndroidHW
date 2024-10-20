package com.example.testapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private long timeOnCreate, timeOnStart, timeOnResume;
    private long timeOnPause, timeOnStop, timeOnDestroy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButtonClick(View view) {
        Log.d(TAG, "onButtonClick: Кнопка була натиснута");
    }

    @Override
    protected void onStart() {
        super.onStart();
        timeOnStart = System.currentTimeMillis();
        Log.d(TAG, "onStart: Activity починається");
        Log.d(TAG, "Час між onCreate і onStart: " + (timeOnStart - timeOnCreate) + " мс");
    }

    @Override
    protected void onResume() {
        super.onResume();
        timeOnResume = System.currentTimeMillis();
        Log.d(TAG, "onResume: Activity відновлюється");
        Log.d(TAG, "Час між onStart і onResume: " + (timeOnResume - timeOnStart) + " мс");
    }

    @Override
    protected void onPause() {
        super.onPause();
        timeOnPause = System.currentTimeMillis();
        Log.d(TAG, "onPause: Activity призупиняється");
    }

    @Override
    protected void onStop() {
        super.onStop();
        timeOnStop = System.currentTimeMillis();
        Log.d(TAG, "onStop: Activity зупиняється");
        Log.d(TAG, "Час між onPause і onStop: " + (timeOnStop - timeOnPause) + " мс");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timeOnDestroy = System.currentTimeMillis();
        Log.d(TAG, "onDestroy: Activity знищується");
        Log.d(TAG, "Час між onStop і onDestroy: " + (timeOnDestroy - timeOnStop) + " мс");
    }
}