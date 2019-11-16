package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sense {
    private String definition;

    private List<String> usageExamples;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getUsageExamples() {
        return usageExamples;
    }

    public void setUsageExamples(List<String> usageExamples) {
        this.usageExamples = usageExamples;
    }

    @Override
    public String toString() {
        return "Sense{" +
                "definition='" + definition + '\'' +
                ", usageExamples='" + usageExamples + '\'' +
                '}';
    }
}
