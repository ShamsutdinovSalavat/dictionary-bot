package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

public class TelegramMethodBuilder {

	public static SendMessageMethod.SendMessageMethodBuilder sendMessage() {
		return new SendMessageMethod.SendMessageMethodBuilder();
	}

	public static SendAudioMethod.SendAudioMethodBuilder sendAudio() {
		return new SendAudioMethod.SendAudioMethodBuilder();
	}
}
