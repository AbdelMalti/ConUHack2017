package com.example.abdeljelil.testchrono;


        import android.app.Activity;
        import android.graphics.Color;
        import android.os.Build;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.SystemClock;
        import android.speech.tts.TextToSpeech;
        import android.speech.tts.Voice;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener{

    private Button startButton;
    private Button pauseButton;
    TextToSpeech tts;
    private boolean isStartClick = false;
    private boolean isRestart = false;

    private TextView timerValue;

    private long startTime = 0L;

    private Handler customHandler = new Handler();

    private EditText input;

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    Color  pauseButtonColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTitle("Voice app");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerValue = (TextView) findViewById(R.id.timerValue);
        tts= new TextToSpeech(this,this);
        startButton = (Button) findViewById(R.id.startButton);
        input = (EditText) findViewById(R.id.editText);

        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(! isStartClick){
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);
                    isStartClick = true;
                    CharSequence restart = "Pause";
                    pauseButton.setText(restart);
                    pauseButton.setBackgroundColor(Color.RED);
                    pauseButton.setTextColor(Color.WHITE);
                    startButton.setClickable(false);
                }if(isRestart){
                    isRestart = false;
                }

            }
        });

        pauseButton = (Button) findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(isStartClick){
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                    isStartClick = false;
                    pauseButton.setBackgroundColor(Color.YELLOW);
                    pauseButton.setTextColor(Color.BLACK);
                    CharSequence restart = "Restart";
                    pauseButton.setText(restart);
                    startButton.setClickable(true);
                }else{
                    CharSequence backToZero = "0:00";
                    timerValue.setText(backToZero);
                    isRestart = true;
                    startTime = SystemClock.uptimeMillis();
                    timeSwapBuff = 0L;

                }
            }
        });

    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            int interval;
            try {
                interval = Integer.parseInt(input.getText().toString());
            }catch (Exception e){
                interval = 5;
            }


            customHandler.postDelayed(this, 0);
            CharSequence minutesText = "";

            if(secs % interval == 0){ // Mettre une variable que l'utilisateur entrera.
                if(mins > 0){
                    minutesText = (mins+" " + "minutes");
                }
                if(secs != 0)
                {
                    CharSequence test = (secs+" " + "seconds");
                    CharSequence text = minutesText + "" + test;
                    tts.setPitch(0.9f);

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        tts.speak(test, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
            timerValue.setText("" + mins + ":" + String.format("%02d", secs));
        }

    };

    @Override
    public void onInit(int i) {

    }
}