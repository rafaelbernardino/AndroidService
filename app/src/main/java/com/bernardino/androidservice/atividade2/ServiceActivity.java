package com.bernardino.androidservice.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.bernardino.androidservice.R;
import com.bernardino.androidservice.atividade2.service.Logger;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, Logger.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, Logger.class);
        stopService(intent);
    }

}
