package ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	private String definition;
	private String partOfSpeech;

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	@Override
	public String toString() {
		return "Result{" +
				"definition='" + definition + '\'' +
				", partOfSpeech='" + partOfSpeech + '\'' +
				'}';
	}
}
