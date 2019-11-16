package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pronunciation {
    private List<Transcription> transcriptions;
    private Audio audio;
    private Context context;


    public List<Transcription> getTranscriptions() {
        return transcriptions;
    }

    public void setTranscriptions(List<Transcription> trascriptions) {
        this.transcriptions = trascriptions;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Pronunciation{" +
                "transcriptions=" + transcriptions +
                ", audio=" + audio +
                ", context=" + context +
                '}';
    }
}
