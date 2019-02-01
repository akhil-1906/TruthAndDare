package com.example.akhil.truthanddare;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rules extends AppCompatActivity {
    Button ib;
    TextView rules,head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ib=(Button)findViewById(R.id.skip);
        head=(TextView)findViewById(R.id.head);
        rules=(TextView)findViewById(R.id.rules);
        rules.setTextColor(Color.BLACK);
        head.setTextColor(Color.BLACK);
        rules.setText("1-Anyone can Rotate the Bottle." +"\n"+"\n"+
                "2-The One Who faces the Thinner End Has To Answer the Question on basis of their Selection." +"\n"+"\n"+
                "3-After Answering the one Who Suppose to ask the question should Verify the Answer." +"\n"+"\n"+
                "4-This Game has AI feature that its Automatically open CAMERA after 5 sec of question that include the task of clicking the Picture.");
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip=new Intent("com.example.akhil.truthanddare.MAINACTIVITY");
                startActivity(skip);
            }
        });
    }
}
