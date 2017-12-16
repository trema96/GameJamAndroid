package gamejam151217.soundrecognition.audio.core;

public interface Callback {
    void onBufferAvailable(byte[] buffer);
}