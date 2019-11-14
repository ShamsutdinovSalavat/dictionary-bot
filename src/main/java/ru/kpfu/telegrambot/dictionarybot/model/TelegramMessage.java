package ru.kpfu.telegrambot.dictionarybot.model;

public enum TelegramMessage {
	INCORRECT_WORD_MESSAGE("Make sure that word is spelled correctly and try it again");


	private final String message;

	TelegramMessage(String message) {
		this.message = message;
	}

	public String value() {
		return this.message;
	}
}
