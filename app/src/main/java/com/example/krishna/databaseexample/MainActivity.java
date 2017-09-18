package com.example.krishna.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationConstant app=(ApplicationConstant)getApplication();
        app.ReadyApplicationDatabase(MainActivity.this);
        Intent i=new Intent(MainActivity.this,AddEmp.class);
        startActivity(i);
    }
}
