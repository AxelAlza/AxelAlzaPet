package com.example.petagram.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petagram.R;
import com.google.android.material.appbar.MaterialToolbar;

public class AcercaDe extends AppCompatActivity {
    MaterialToolbar Mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //MaterialToolbar init//
        Mt = findViewById(R.id.topAppBar);
        Mt.setNavigationIcon(R.drawable.back);
        Mt.setTitle("Acerca de");
        setSupportActionBar(Mt);
        Mt.setNavigationOnClickListener(v -> finish());
        //MaterialToolbar init//
    }
}