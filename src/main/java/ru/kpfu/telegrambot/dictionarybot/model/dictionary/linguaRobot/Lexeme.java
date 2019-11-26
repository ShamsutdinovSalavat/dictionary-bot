package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lexeme {
	private String lemma;
	private String partOfSpeech;
	private List<Sense> senses;

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	public List<Sense> getSenses() {
		return senses;
	}

	public void setSenses(List<Sense> senses) {
		this.senses = senses;
	}

	@Override
	public String toString() {
		return "Lexeme{" +
				"lemma='" + lemma + '\'' +
				", partOfSpeech='" + partOfSpeech + '\'' +
				", senses=" + senses +
				'}';
	}
}
