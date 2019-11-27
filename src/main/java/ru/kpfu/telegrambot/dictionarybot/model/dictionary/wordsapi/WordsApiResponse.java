package ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WordsApiResponse extends DictionaryResponse {

	private String word;
	private List<Result> results;
	private Pronunciation pronunciation;

	@Override
	public String getDefinition() {
		return results.get(0).getDefinition();
	}

	@Override
	public String getWord() {
		return word;
	}

	@Override
	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public void setPronunciation(Pronunciation pronunciation) {
		this.pronunciation = pronunciation;
	}

	@Override
	public String toString() {
		return "WordsApiResponse{" +
				"word='" + word + '\'' +
				", results=" + results +
				", pronunciation=" + pronunciation +
				'}';
	}
}
