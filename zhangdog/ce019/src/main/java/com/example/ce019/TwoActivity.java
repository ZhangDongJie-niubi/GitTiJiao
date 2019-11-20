package com.example.ce019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ce019.bean.EvenMeg;
import com.example.ce019.server.HomeServer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TwoActivity extends AppCompatActivity {

    private ProgressBar pb;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        pb = findViewById(R.id.pb);
        tv1 = findViewById(R.id.tv1);
        Button but = findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoActivity.this, HomeServer.class);
               startService(intent);

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(EvenMeg evenMeg) {
        final long a = evenMeg.getA();
        final long l = evenMeg.getL();
        pb.setMax((int) l);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pb.setProgress((int) a);
                tv1.setText(a * 100 / l + "%");
                Log.e("TAG", "run: "+a );
                if (a == l) {
                    Toast.makeText(TwoActivity.this, "下載完成", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Intent intent = new Intent(TwoActivity.this, HomeServer.class);
        stopService(intent);
    }
}
