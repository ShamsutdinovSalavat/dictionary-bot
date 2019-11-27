package ru.kpfu.telegrambot.dictionarybot.model.bot.method;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("method")
public class SendAudioMethod extends TelegramResponse {

	@JsonProperty("chat_id")
	private final Integer chatId;
	private final String audio;
	private final String caption;

	@JsonProperty("parse_mode")
	private final String parseMode;
	private final String title;

	private SendAudioMethod(Integer chatId, String audio, String caption, String parseMode, String title) {
		this.chatId = chatId;
		this.audio = audio;
		this.caption = caption;
		this.parseMode = parseMode;
		this.title = title;
	}

	@Override
	@JsonProperty("method")
	public String getMethod() {
		return "sendAudio";
	}

	public Integer getChatId() {
		return chatId;
	}

	public String getAudio() {
		return audio;
	}

	public String getCaption() {
		return caption;
	}

	public String getParseMode() {
		return parseMode;
	}

	public String getTitle() {
		return title;
	}

	public static class SendAudioMethodBuilder {

		private Integer chatId;
		private String audio;
		private String caption;
		private String parseMode;
		private String title;

		public SendAudioMethodBuilder setChatId(Integer chatId) {
			this.chatId = chatId;
			return this;
		}

		public SendAudioMethodBuilder setAudio(String audio) {
			this.audio = audio;
			return this;
		}

		public SendAudioMethodBuilder setCaption(String caption) {
			this.caption = caption;
			return this;
		}

		public SendAudioMethodBuilder setParseMode(String parseMode) {
			this.parseMode = parseMode;
			return this;
		}

		public SendAudioMethodBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public SendAudioMethod build() {
			return new SendAudioMethod(chatId, audio, caption, parseMode, title);
		}
	}
}
