package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

import java.util.List;

public class LinguaRobotResponse extends DictionaryResponse {
    @JsonProperty("entries")
    private List<Entry> entry;

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public String getDefinition() {

        return entry.get(0).getLexemes().get(0).getSenses().get(0).getDefinition();
    }

    @Override
    public String toString() {
        return "LinguaRobotResponse{" +
                "entry=" + entry +
                '}';
    }
}
