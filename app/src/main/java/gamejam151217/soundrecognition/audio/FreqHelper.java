package gamejam151217.soundrecognition.audio;

public class FreqHelper {
    public static double GetFreqAmplitude(double[] amplitudeDB, int frequencyHz) {
        int sampleRate = 44100;
        int index = amplitudeDB.length  * frequencyHz / sampleRate;
        return amplitudeDB[index];
    }
}
