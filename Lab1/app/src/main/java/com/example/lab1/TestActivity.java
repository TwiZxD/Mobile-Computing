package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleBookManager SBM = new SimpleBookManager();
        setContentView(R.layout.activity_test);
    }
}
