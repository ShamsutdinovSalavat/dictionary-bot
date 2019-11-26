package ru.kpfu.telegrambot.dictionarybot.config;

import org.springframework.stereotype.Component;

@Component
public class WordsApiConfig extends RapidApiConfig {

	public static final String URL = "https://wordsapiv1.p.rapidapi.com";
	public static final String WORDS_METHOD = URL + "/words/{word}";

	@Override
	protected void setUrlHeader() {
		headers.add("x-rapidapi-host", URL.replace("https://", ""));
	}

	public String getUrl() {
		return URL;
	}
}