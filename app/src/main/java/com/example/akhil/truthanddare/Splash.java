package com.example.akhil.truthanddare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class Splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.splash);
        Thread run=new Thread(){
            @Override
            public void run() {
        try{
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Intent a=new Intent("com.example.akhil.truthanddare.RULES");
            startActivity(a);
        }
        }
    };
        run.start();
    }
}
