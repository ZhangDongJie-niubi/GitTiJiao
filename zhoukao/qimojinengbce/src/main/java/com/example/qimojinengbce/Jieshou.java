package com.example.qimojinengbce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Jieshou extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();

        Intent intent1 = new Intent(context, sevenActivity.class);
        context.startActivity(intent1);
    }
}
