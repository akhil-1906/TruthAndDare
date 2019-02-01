package com.example.akhil.truthanddare;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dare extends AppCompatActivity {
    TextView ques,display;
    Button back;
    String a;
    int randomElement;
    ImageView im;
    Bitmap bm;
    String[] arr_Dare = {"Put an ice cube down your pants until it melts.",
            "Enact a kissing scene using a book.",
            "Go on the balcony and keep shouting 'I love you' to any person who passes by.",
            "Wear your underpants over your pair of trousers and run around the house yelling 'Im the Super Man!' and Click your Picture",
            "Peel a banana using your feet.",
            "Smell the feet of everyone in the room and rank them from best to worst with Picture.",
            "Get on all four and howl and bark at another player anytime they move or speak for the next 3 rounds.",
            "Take an item of food from the refrigerator and kiss it passionately for 90 seconds",
            "Come up with a cutesy pet name for everyone in the group.",
            "Go into the bathroom and make a toilet paper shirt. You have to wear it for the next two rounds.",
            "Call your crush and tell him in a seductive voice what turns you on.",
            "Select another player and repeat everything they say for the next 3 rounds.",
            "Stick jelly between all your toes and leave it there for 20 minutes.",
            "If your special someone is around, slap him/her and make it hard.",
            "Perform belly dancing standing at the center of the circle.",
            "Dress up like a girl along with makeup (for guys) and Send the Picture to other.",
            "Clean the toilet with your toothbrush.",
            "Take Picture With Dog",
            "Lick the belly button of the person sitting next to you.",
            "Try to sit on a dog and make him ride you the entire house and Click Your Picture",
            "Go to the next door neighbor and ask them to watch you perform and click your Pictures ",
            "Kiss a given person for a given amount of time ",
            "Find something edible in the kitchen for the person to eat that isn't meant to be eaten straight (ketchup, salt, flour, ...)",
            "Have your victim run around outside screaming something totally inane. An example being have I guy go chanting 'I am woman, hear me roar!'",
            "Dare a guy to put on full woman's makeup or let the girls do it.",
            "Go out on your porch and sing the 'I'm a Little Teapot' song.",
            "Get a guy to go out into a public area scratching their crotch and saying, 'Damn these crabs really itch!'",
            "Dare a male player to let all the girl players remove his shoes and socks so they can paint his toes with nail polish. He must remain barefoot until the game is over and hope he hasn't lost his shoes and socks while playing.",
            "Have a person smear jelly in one armpit and peanut butter in the other armpit. Then they must take two slices of bread and wipe it off. Then they have to eat the sandwich!",
            "Eat a piece of food (such as a grape or whip cream) off someone of the opposite gender's tongue.",
            "Push a penny around the toilet seat with your tongue.",
            "Have a guy make-out with a pillow or teddy bear for a certain amount of time, have him say the girls name he likes and make kissing noises.",
            "The person being dared must pick a guy and that guy must do that girls makeup with a blindfold on.",
            "Have a guy kiss every girl, and then tell who has the worst and/or best breath.",};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dare);
        ques = (TextView) findViewById(R.id.ques);
        back = (Button) findViewById(R.id.back);
        display = (TextView) findViewById(R.id.display);
        im = (ImageView)findViewById(R.id.im);

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(Dare.this);
        builder2.setCancelable(false);
        final AlertDialog.Builder mess = new AlertDialog.Builder(Dare.this);
        mess.setCancelable(true);
        ques.setTextColor(Color.GREEN);
        display.setTextColor(Color.GREEN);
        randomElement = (int) (Math.random() * (arr_Dare.length - 1));
        ques.setText(arr_Dare[randomElement]);
        String cam = ques.getText().toString();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder2.setMessage("Has he Performed the Task Given to him??");
                builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent b = new Intent(Dare.this, MainActivity.class);
                        startActivity(b);
                    }
                });
                builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mess.setMessage("Sorry!! , But to Spin the Bottle again You have Perform the Task ");
                        mess.create();
                        mess.show();
                    }
                });
                builder2.create();
                builder2.show();
            }
        });
        Thread run = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    String cam = ques.getText().toString();
                    if (cam.contains("Picture")) {
                        Intent Camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(Camera, 1888);
                    }
                }
            }
        };
        run.start();
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1888){
            bm=(Bitmap)data.getExtras().get("data");
            im.setImageBitmap(bm);
        }
    }
}