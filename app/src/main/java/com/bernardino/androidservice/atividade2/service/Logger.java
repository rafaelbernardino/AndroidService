package com.bernardino.androidservice.atividade2.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rm31243 on 28/11/2016.
 */
public class Logger extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("ServicoMensagem", "===Serviço iniciado===");
    }

    @Override
    public void onDestroy() {
        Log.i("ServicoMensagem", "===Serviço finalizado===");
    }
}
