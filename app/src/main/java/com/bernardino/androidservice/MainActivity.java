package com.bernardino.androidservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bernardino.androidservice.receiver.AlarmReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disparar(View view) {
        EditText txtTempo = (EditText) findViewById(R.id.etTempoId);

        if (txtTempo != null && txtTempo.getText() != null && !txtTempo.getText().toString().equals("")) {
            int tempo = Integer.parseInt(txtTempo.getText().toString());

            Intent i = new Intent(this, AlarmReceiver.class);

            PendingIntent pi = PendingIntent.getBroadcast(this.getApplicationContext(), 0, i, 0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (tempo * 1000), pi);

//            sendBroadcast(i);

            Toast.makeText(this, "Alarm setado para " + tempo + " segundos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Favor informar o tempo", Toast.LENGTH_LONG).show();
        }
    }
}
