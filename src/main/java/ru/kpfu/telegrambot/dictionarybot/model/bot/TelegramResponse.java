package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class TelegramResponse {

	@JsonProperty("method")
	public abstract String getMethod();
}
