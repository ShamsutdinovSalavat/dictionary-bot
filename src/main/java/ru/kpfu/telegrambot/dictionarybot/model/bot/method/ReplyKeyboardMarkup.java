package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyKeyboardMarkup {

	private final List<List<KeyboardButton>> keyboard;

	@JsonProperty(value = "resize_keyboard")
	private final boolean resizeKeyboard;

	@JsonProperty(value = "one_time_keyboard")
	private final boolean oneTimeKeyboard;

	private ReplyKeyboardMarkup(List<List<KeyboardButton>> keyboard, boolean resizeKeyboard, boolean oneTimeKeyboard) {
		this.keyboard = keyboard;
		this.resizeKeyboard = resizeKeyboard;
		this.oneTimeKeyboard = oneTimeKeyboard;
	}

	public List<List<KeyboardButton>> getKeyboard() {
		return keyboard;
	}

	public boolean isResizeKeyboard() {
		return resizeKeyboard;
	}

	public boolean isOneTimeKeyboard() {
		return oneTimeKeyboard;
	}

	public static class ReplyKeyboardMarkupBuilder {

		private List<List<KeyboardButton>> keyboardRows = new ArrayList<>();
		private boolean resizeKeyboard;
		private boolean oneTimeKeyboard;
		private SendMessageMethod.SendMessageMethodBuilder builder;

		public ReplyKeyboardMarkupBuilder(SendMessageMethod.SendMessageMethodBuilder builder) {
			this.builder = builder;
		}

		public ReplyKeyboardMarkupBuilder setKeyboardRow(List<KeyboardButton> keyboardRow) {
			this.keyboardRows.add(keyboardRow);
			return this;
		}

		public ReplyKeyboardMarkupBuilder setKeyboard(List<List<KeyboardButton>> keyboard) {
			this.keyboardRows = keyboard;
			return this;
		}

		public ReplyKeyboardMarkupBuilder setResizeKeyboard(boolean resizeKeyboard) {
			this.resizeKeyboard = resizeKeyboard;
			return this;
		}

		public ReplyKeyboardMarkupBuilder setOneTimeKeyboard(boolean oneTimeKeyboard) {
			this.oneTimeKeyboard = oneTimeKeyboard;
			return this;
		}

		public SendMessageMethod.SendMessageMethodBuilder build() {
			ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(keyboardRows, resizeKeyboard, oneTimeKeyboard);
			this.builder.setReplyMarkup(keyboardMarkup);
			return this.builder;
		}
	}
}
