package com.malti.abdeljelil.cardiotime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_start;
    private TextView 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button_start= (Button) findViewById(R.id.playButton);

        setContentView(R.layout.activity_main);
    }
}
