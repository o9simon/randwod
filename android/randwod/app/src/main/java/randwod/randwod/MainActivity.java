package randwod.randwod;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    ExerciseDefinitionList el;
    Timer timer;

    StrikethroughableTextView textViewExercise1;
    StrikethroughableTextView textViewExercise2;
    StrikethroughableTextView textViewExercise3;
    StrikethroughableTextView textViewExercise4;
    StrikethroughableTextView textViewExercise5;
    TextView textViewTimer;
    Button buttonPlay;
    Button buttonPause;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.el = new ExerciseDefinitionList();
        this.timer = new Timer();

        this.textViewExercise1 = (StrikethroughableTextView)findViewById(R.id.textViewExercise1);
        this.textViewExercise2 = (StrikethroughableTextView)findViewById(R.id.textViewExercise2);
        this.textViewExercise3 = (StrikethroughableTextView)findViewById(R.id.textViewExercise3);
        this.textViewExercise4 = (StrikethroughableTextView)findViewById(R.id.textViewExercise4);
        this.textViewExercise5 = (StrikethroughableTextView)findViewById(R.id.textViewExercise5);
        this.textViewTimer = (TextView)findViewById(R.id.textViewTimer);
        this.buttonPlay = (Button)findViewById(R.id.buttonPlay);
        this.buttonPause = (Button)findViewById(R.id.buttonPause);
        this.buttonNext = (Button)findViewById(R.id.buttonNext);

        this.textViewExercise1.setOnClickListener(new ToggleStrikethroughOnClickListener(textViewExercise1));
        this.textViewExercise2.setOnClickListener(new ToggleStrikethroughOnClickListener(textViewExercise2));
        this.textViewExercise3.setOnClickListener(new ToggleStrikethroughOnClickListener(textViewExercise3));
        this.textViewExercise4.setOnClickListener(new ToggleStrikethroughOnClickListener(textViewExercise4));
        this.textViewExercise5.setOnClickListener(new ToggleStrikethroughOnClickListener(textViewExercise5));

        this.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        this.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                buttonPlay.setVisibility(View.INVISIBLE);
                buttonPause.setVisibility(View.VISIBLE);
            }
        });

        this.buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.pause();
                buttonPlay.setVisibility(View.VISIBLE);
                buttonPause.setVisibility(View.INVISIBLE);
            }
        });

        buttonPlay.setVisibility(View.VISIBLE);
        buttonPause.setVisibility(View.INVISIBLE);

        timer.addObserver(this);
        next();
    }

    private void next() {
        ExerciseList list = el.getExerciseList(5);

        textViewExercise1.setText(list.get(0).getReps() + "x " + list.get(0).getName());
        textViewExercise2.setText(list.get(1).getReps() + "x " + list.get(1).getName());
        textViewExercise3.setText(list.get(2).getReps() + "x " + list.get(2).getName());
        textViewExercise4.setText(list.get(3).getReps() + "x " + list.get(3).getName());
        textViewExercise5.setText(list.get(4).getReps() + "x " + list.get(4).getName());

        textViewExercise1.unstrike();
        textViewExercise2.unstrike();
        textViewExercise3.unstrike();
        textViewExercise4.unstrike();
        textViewExercise5.unstrike();

        buttonPlay.setVisibility(View.VISIBLE);
        buttonPause.setVisibility(View.INVISIBLE);
        textViewTimer.setTextColor(Color.BLACK);
        timer.setSeconds(list.getTime());
    }

    @Override
    public void update(Observable o, Object arg) {
        int seconds = (int)arg;

        if (seconds == 0) {
            textViewTimer.setTextColor(Color.RED);
            ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
            toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
        }

        textViewTimer.setText(String.format("%02d:%02d", (seconds % 3600) / 60, seconds % 60));
    }

}
