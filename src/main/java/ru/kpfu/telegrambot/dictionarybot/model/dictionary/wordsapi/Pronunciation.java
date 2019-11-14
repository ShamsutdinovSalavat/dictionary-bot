package ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pronunciation {

	@JsonProperty(value = "all")
	private String transcription;

	public String getTranscription() {
		return transcription;
	}

	public void setTranscription(String transcription) {
		this.transcription = transcription;
	}

	@Override
	public String toString() {
		return "Pronunciation{" +
				"transcription='" + transcription + '\'' +
				'}';
	}
}
