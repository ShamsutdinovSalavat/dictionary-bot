package ru.kpfu.telegrambot.dictionarybot.model;

public enum TelegramMessage {
	INCORRECT_WORD_MESSAGE("Make sure that word is spelled correctly and try it again"),
	WORDS_IS_EMPTY_MESSAGE("The first you need to search some words");


	private final String message;

	TelegramMessage(String message) {
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
