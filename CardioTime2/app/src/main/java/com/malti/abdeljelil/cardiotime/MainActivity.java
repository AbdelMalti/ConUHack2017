package com.example.admin.texttospeach;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public abstract class MainActivity extends Activity implements TextToSpeech.OnInitListener{



    Button button_start,button_stop;
    TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_to_speach);
        //button start pour le timer
        button_start= (Button) findViewById(R.id.button_start);
        button_start.setOnClickListener(this);

        tts= new TextToSpeech(this,this);


    }


}

public void onClick(View v){


    //TODO generer timer

    //if(variable==timer){

        //tts.speak(timer)


   // }










    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            mTts.speak("Ceci est un test grandeur nature du tutoriel sur l'énonciation de texte.", TextToSpeech.QUEUE_FLUSH, null);
            mTts.speak("Ceci est un deuxième test !", TextToSpeech.QUEUE_ADD, null);
        }
    }


}