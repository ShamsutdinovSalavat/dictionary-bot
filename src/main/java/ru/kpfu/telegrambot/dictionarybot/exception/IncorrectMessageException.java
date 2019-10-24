package ru.kpfu.telegrambot.dictionarybot.exception;

public class IncorrectMessageException extends Exception {
	public IncorrectMessageException() {
	}

	public IncorrectMessageException(String message) {
		super(message);
	}

	public IncorrectMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectMessageException(Throwable cause) {
		super(cause);
	}

	public IncorrectMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
