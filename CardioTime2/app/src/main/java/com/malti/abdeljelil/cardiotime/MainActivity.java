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




public class MainActivity extends Activity implements TextToSpeech.OnInitListener{

    private void speakIt(){
            CharSequence test = "BITCH PLEASE!.. I'm tired. Not going for any run. Not today. Not tomorrow. Couch potato life for me";
        tts.setPitch(0.5f);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(test, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else{
            tts.speak(test.toString(), TextToSpeech.QUEUE_FLUSH, null);
        }

    }

    Button button_start ,button_stop;
    private boolean isPlaying = false;
    TextToSpeech tts;
    //TextView timerValue;
    int hours;
    int minutes;
    int secondes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button start pour le timer
        tts= new TextToSpeech(this,this);

        TextView textTimer = (TextView) findViewById(R.id.textView);
        button_start= (Button) findViewById(R.id.playButton);

        //System.out.println(timerValue.getId());
        //String temp = timerValue.getText().toString();
/*
        hours = (int) temp.charAt(0);
        String tempMin = temp.substring(4,6);
        System.out.println(tempMin);
*/
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakIt();
                if(isPlaying){
                    button_start.setText("PAUSE");
                }else{
                    button_start.setText("PLAY");
                }
                isPlaying = ! isPlaying;
            }
        });
    }

    private void compteur(){

    }


    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
           // mTts.speak("Ceci est un test grandeur nature du tutoriel sur l'�nonciation de texte.", TextToSpeech.QUEUE_FLUSH, null);
           // mTts.speak("Ceci est un deuxi�me test !", TextToSpeech.QUEUE_ADD, null);
        }
    }


}