package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

public class KeyboardButton {

	private String text;

	public KeyboardButton(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
