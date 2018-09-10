package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  SimpleBookManager SBM = new SimpleBookManager();
        Log.d("LogDebug","Message");
        setContentView(R.layout.activity_test);
    }
}
