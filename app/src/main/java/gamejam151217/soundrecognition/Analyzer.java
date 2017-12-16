package gamejam151217.soundrecognition;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class Analyzer {
    private static final int MAX_FREQ = 22050; //maxFreq * 2
    private static final int SAMPLE_RATE = 44100; //maxFreq * 2
    private final int minSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, AudioFormat.
                    CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT);
    private final AudioRecord audioInput = new AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLE_RATE,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            minSize);

    private void tmp() {
        short[] buffer = new short[minSize];
        audioInput.startRecording();
        audioInput.read(buffer, 0, minSize); // record data from mic into buffer
    }
}
