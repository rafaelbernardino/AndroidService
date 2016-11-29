package com.bernardino.androidservice.atividade5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bernardino.androidservice.R;
import com.bernardino.androidservice.atividade5.service.BoundService;

public class BoundActivity extends AppCompatActivity {

    TextView txtTimestamp;
    Button btPrintTimestamp;
    Button btStopService;
    boolean mServiceBound;
    BoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        txtTimestamp = (TextView) findViewById(R.id.tvTempoId);
        btPrintTimestamp = (Button) findViewById(R.id.btPrintTimestampId);
        btStopService = (Button) findViewById(R.id.btStopService);
    }

    public void print(View view) {
        if (mServiceBound) {
            txtTimestamp.setText(mBoundService.getTimestamp());
        }
    }

    public void stop(View view) {
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }

        Intent intent = new Intent(BoundActivity.this, BoundService.class);
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}
