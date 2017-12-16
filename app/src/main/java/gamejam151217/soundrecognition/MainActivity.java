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

    private GraphView gView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gView = (GraphView) findViewById(R.id.graph);
        recorder = new Recorder(new Callback() {
            @Override
            public void onBufferAvailable(byte[] buffer) {
                //getAmplDB returns an array of doubles representing the amplitude of each frequency
                //with the current settings the array is 1024 doubles, where the first one is a frequency of 0 and the last one 22050 (sampleRate / 2)
                audioCalculator.setBytes(buffer);
                gView.update(audioCalculator.getAmplDB());
                gView.postInvalidate();
            }
        });
        recorder.start();
    }
}
