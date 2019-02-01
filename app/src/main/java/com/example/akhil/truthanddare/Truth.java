package com.example.akhil.truthanddare;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Truth extends AppCompatActivity {
    TextView ques,display;
    Button back;
    String a;
    int randomElement;
    String[] arr_Truth = {	"What is the question that you do not want anyone to ask you in this game?",
            "Describe the sexiest clothes you wore and to impress whom?",
            "Has anyone ever seen you completely naked? If yes, who?",
            "Would you ever cheat on your girlfriend/boyfriend?",
            "What is your wildest sexual fantasy?",
            "Describe your first intimate experience.",
            "What is your bedroom nickname?",
            "If you were the opposite sex for one day, what would you look like and what would you do?",
            "Who has presented you with the worst birthday gift so far?",
            "What is the first physical feature you look for in someone you are attracted to?",
            "Do you still pine for your ex flame?",
            "What is the stupidest thing that you have done in front of a crowd?",
            "Whom would you like to marry from amongst the group in this room and why?",
            "What flaw is enough to cause you to break off a relationship?",
            "Have you had a crush on your best friend?",
            "What is the most daring and crazy thing that you have done in front of a large crowd?",
            "Which is the most sensual pair of clothing you own?",
            "What is the silliest thing that you have said to your partner, while being intimate?",
            "What animal most resembles your personality?",
            "Have you ever kissed someone of the same sex? Who? ",
            "Ask a girl if she were a guy which girl in the room she would date. (do the same to a guy)",
            "Your lover has been magically transformed into an animal, and the only way to restore your lover is to mate with them. Here's the question: Which animal would cause you the least psychological damage?",
            "Have you ever cheated on your bf/gf (if they have one), or would you ever cheat?",
            "Have you ever gone a whole day without wearing underwear? (This question pertains to both bra and panties for women)",
            "If you could be born again would choose to be a different sex to what you are?",
            "If you had 24 hours to live, what would you do, what movie star would you want to kiss, and who would you notify that you are dying",
            "Describe the sexiest clothes you ever wore and why.",
            "When did you stop bathing with your sibling?",
            "Who has the biggest ball you've ever seen? (funny since it can be told literally, but someone will take it sexually. I could be talking about a medicine ball!!!)",
            "If I was a food what would I be and how would you eat me?!?!",
            "Ask a girl/boy what they would do to a girl/boy, of the opposite sex, for a Klondike Bar.",
            "How far have you gone?",
            "How far would you go with someone that you just met?",
            "What is the most embarrassing thing you've done?",
            "Have you ever skinny dipped?",
            "Would you marry your bf/gf?",
            "Do you really love your bf/gf?",
            "Have you ever made an ass of yourself in front of someone you were interested in?",
            "What is the stupidest thing you've done because someone dared you to?",
            "What is the stupidest thing you've done on your own free will?",
            "Tell everyone who you like.",
            "What is the strangest dream you've ever had.Describe in detail.",
            "Ask the victim what question would he most dread to be asked (This way they'll either have to answer it on their next turn or play just plain dare for the rest of their life)",
            "What's your favorite thing about the opposite sex?",
            "What's the worst thing about being your gender?",
            "If you could have anyone here in the room to be your slave, who would it be and what would you make them do?",
            "Rate everyone on a scale of 1-10 What's your idea of a perfect date?",
            "What is your most embarrassing memory?",
            "What was your most perverted dream?",
            "Describe your first sexual experience",
            "Describe your worst sexual encounter",
            "What's your bra size?",
            "How long is your penis?",
            "Who's your strangest crush?",
            "Do you have any crushes now?",
            "If you had to snog one person in the room, who would it be?",
            "Do you have any fetishes?",
            "Do you have any irrational fears?",
            "What's the worst thing you've ever stolen?",
            "Where was the strangest place you've had sex?",
            "Have you ever masturbated anywhere inappropriate? Elaborate...",
            "What's the strangest porn you've ever got off on?",
            "Have you ever had a crush on anyone in the room?",
            "When was the last time you had sex?",
            "Who was your first crush?",
            "Describe your guilty pleasure",
            "What's the best sex you ever had?",
            "Describe your favourite features",
            "Describe your least favourite features",
            "Have you ever had sex/a crush on someone you shouldn't have? Who?"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_truth);
        ques=(TextView)findViewById(R.id.ques);
        back=(Button)findViewById(R.id.back);
        display=(TextView)findViewById(R.id.display);

        final AlertDialog.Builder builder2=new AlertDialog.Builder(Truth.this);
        builder2.setCancelable(false);
        final AlertDialog.Builder mess=new AlertDialog.Builder(Truth.this);
        mess.setCancelable(true);
        ques.setTextColor(Color.GREEN);
        display.setTextColor(Color.GREEN);
        randomElement = (int)(Math.random() * (arr_Truth.length - 1));
        ques.setText(arr_Truth[randomElement]);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder2.setMessage("Has he Answered the Question asked to him??");
                builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent b=new Intent(Truth.this,MainActivity.class);
                        startActivity(b);
                    }
                });
                builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mess.setMessage("Sorry!! , But to Spin the Bottle again You have to Answer the Question ");
                        mess.create();
                        mess.show();
                    }
                });
                builder2.create();
                builder2.show();
            }
        });
        }
    }