package com.malti.abdeljelil.cardiotime;

import android.app.Activity;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public abstract class MainActivity extends Activity implements TextToSpeech.OnInitListener{



    Button button_start ,button_stop;
    TextToSpeech tts;


    //Button button_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button start pour le timer
        button_start= (Button) findViewById(R.id.playButton);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence test = "this is the second try !";
                //tts.speak(test, TextToSpeech.QUEUE_ADD, null, null);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(test, TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else{
                    tts.speak(test.toString(), TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });

        tts= new TextToSpeech(this,this);

    }


public void onClick(View v){


    //TODO generer timer

    //if(variable==timer){

        //tts.speak(timer)


    }










    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
           // mTts.speak("Ceci est un test grandeur nature du tutoriel sur l'�nonciation de texte.", TextToSpeech.QUEUE_FLUSH, null);
           // mTts.speak("Ceci est un deuxi�me test !", TextToSpeech.QUEUE_ADD, null);
        }
    }


}