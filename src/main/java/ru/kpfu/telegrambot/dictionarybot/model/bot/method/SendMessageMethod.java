package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("method")
public class SendMessageMethod extends TelegramResponse {

	private final String method = "sendMessage";

	@JsonProperty("chat_id")
	private final Integer chatId;

	private final String text;

	@JsonProperty("parse_mode")
	private final String parseMode;

	@JsonProperty("reply_markup")
	private final ReplyKeyboardMarkup replyMarkup;

	private SendMessageMethod(Integer chatId, String text, String parseMode, ReplyKeyboardMarkup replyMarkup) {
		this.chatId = chatId;
		this.text = text;
		this.parseMode = parseMode;
		this.replyMarkup = replyMarkup;
	}

	@Override
	public String getMethod() {
		return method;
	}

	public Integer getChatId() {
		return chatId;
	}

	public String getText() {
		return text;
	}

	public String getParseMode() {
		return parseMode;
	}

	public ReplyKeyboardMarkup getReplyMarkup() {
		return replyMarkup;
	}

	public static class SendMessageMethodBuilder {

		private Integer chatId;
		private String text;
		private String parseMode;
		private ReplyKeyboardMarkup replyMarkup;

		public ReplyKeyboardMarkup.ReplyKeyboardMarkupBuilder setReplyMarkup() {
			return new ReplyKeyboardMarkup.ReplyKeyboardMarkupBuilder(this);
		}

		public SendMessageMethodBuilder setReplyMarkup(ReplyKeyboardMarkup replyMarkup) {
			this.replyMarkup = replyMarkup;
			return this;
		}

		public SendMessageMethod.SendMessageMethodBuilder setChatId(Integer chatId) {
			this.chatId = chatId;
			return this;
		}

		public SendMessageMethod.SendMessageMethodBuilder setText(String text) {
			this.text = text;
			return this;
		}

		public SendMessageMethod.SendMessageMethodBuilder setParseMode(String parseMode) {
			this.parseMode = parseMode;
			return this;
		}

		public SendMessageMethod build() {
			return new SendMessageMethod(chatId, text, parseMode, replyMarkup);
		}
	}
}
