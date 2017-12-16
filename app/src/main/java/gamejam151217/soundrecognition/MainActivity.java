package gamejam151217.soundrecognition;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import gamejam151217.soundrecognition.audio.GraphView;
import gamejam151217.soundrecognition.audio.calculators.AudioCalculator;
import gamejam151217.soundrecognition.audio.core.Callback;
import gamejam151217.soundrecognition.audio.core.Recorder;

public class MainActivity extends Activity {

    private Recorder recorder;
    private AudioCalculator audioCalculator = new AudioCalculator();
    private Handler handler;

    private TextView textAmplitude;
    private TextView textDecibel;
    private TextView textFrequency;
    private TextView cView;
    private TextView cView2;
    private GraphView gView;
    //private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gView = (GraphView) findViewById(R.id.graph);
        recorder = new Recorder(new Callback() {
            @Override
            public void onBufferAvailable(byte[] buffer) {
                audioCalculator.setBytes(buffer);
                gView.update(audioCalculator.getAmplDB());
                gView.postInvalidate();
            }
        });
        recorder.start();

        /*
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        recorder = new Recorder(new Callback() {

            @Override
            public void onBufferAvailable(byte[] buffer) {
                audioCalculator.setBytes(buffer);
                int amplitude = audioCalculator.getAmplitude();
                double decibel = audioCalculator.getDecibel();
                final double frequency = audioCalculator.getFrequency();

                final String amp = String.valueOf(amplitude + " Amp");
                final String db = String.valueOf(decibel + " db");
                final String hz = String.valueOf(frequency + " Hz");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textAmplitude.setText(amp);
                        textDecibel.setText(db);
                        textFrequency.setText(hz);

                        double[] stuff = audioCalculator.getAmplDB();
                        int freq = 18000;
                        int sampleRate = 44100;
                        int index = stuff.length  * freq / sampleRate;
                        cView.setText(String.format(Locale.getDefault(), "%f", stuff[index]));
                        cView2.setText(String.format(Locale.getDefault(), "%f", stuff[index + 1]));
                        cView.setText(String.format(Locale.getDefault(), "%d", stuff.length));
                    }
                });
            }
        });
        audioCalculator = new AudioCalculator();
        handler = new Handler(Looper.getMainLooper());

        textAmplitude = (TextView) findViewById(R.id.textAmplitude);
        textDecibel = (TextView) findViewById(R.id.textDecibel);
        textFrequency = (TextView) findViewById(R.id.textFrequency);
        cView = (TextView) findViewById(R.id.counter);
        cView.setText("0");
        cView2 = (TextView) findViewById(R.id.counter2);
        cView2.setText("0");*/
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        recorder.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        recorder.stop();
    }*/
}
