package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {
	private String entry;
	private List<Pronunciation> pronunciations;
	private List<Lexeme> lexemes;

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public List<Pronunciation> getPronunciations() {
		return pronunciations;
	}

	public void setPronunciations(List<Pronunciation> pronunciations) {
		this.pronunciations = pronunciations;
	}

	public List<Lexeme> getLexemes() {
		return lexemes;
	}

	public void setLexemes(List<Lexeme> lexemes) {
		this.lexemes = lexemes;
	}

	@Override
	public String toString() {
		return "Entry{" +
				"entry='" + entry + '\'' +
				", pronunciations=" + pronunciations +
				", lexemes=" + lexemes +
				'}';
	}
}
