package com.example.akhil.truthanddare;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        bottle=(ImageView)findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!spinning){
                    int newDir = random.nextInt(2000);
                    float pivotX = bottle.getWidth() / 2;
                    float pivotY = bottle.getHeight() / 2;
                    Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
                    rotate.setDuration(8000);
                    rotate.setFillAfter(true);
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinning = true;
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spinning = false;
                            final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                            builder.setCancelable(false);
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                            builder1.setMessage("Select Any option");
                            builder1.setCancelable(false);

                            builder1.setPositiveButton("Dare", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent c=new Intent(MainActivity.this,Dare.class);
                                            startActivity(c);
                                        }
                                        });
                            builder1.setNegativeButton("Truth", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent b=new Intent(MainActivity.this,Truth.class);
                                            startActivity(b);
                                        }
                            });
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                            }
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    lastDir = newDir;
                    bottle.startAnimation(rotate);
                }
            }
        });
    }
}
