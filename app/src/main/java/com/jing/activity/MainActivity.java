package com.jing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img_wel = (ImageView) findViewById(R.id.img_wel);
        final MyHandler handler=new MyHandler();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },3000);
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
