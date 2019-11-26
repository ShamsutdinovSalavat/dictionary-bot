package ru.kpfu.telegrambot.dictionarybot.config;

import org.springframework.stereotype.Component;

@Component
public class LinguaRobotConfig extends RapidApiConfig {

	public static final String URL = "https://api.linguarobot.io/language/v1";
	public static final String ENTRIES_METHOD = URL + "/entries/en/{word}";


	@Override
	protected void setUrlHeader() {
		headers.add("x-rapidapi-host", URL.replace("https://", ""));
	}

	public String getUrl() {
		return URL;
	}
}
