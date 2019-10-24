package ru.kpfu.telegrambot.dictionarybot.exception;

public class WordNotFoundException extends Exception {
	public WordNotFoundException() {
	}

	public WordNotFoundException(String message) {
		super(message);
	}

	public WordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public WordNotFoundException(Throwable cause) {
		super(cause);
	}

	public WordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
