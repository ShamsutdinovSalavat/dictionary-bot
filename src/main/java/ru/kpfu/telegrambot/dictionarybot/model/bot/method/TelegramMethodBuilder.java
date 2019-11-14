package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

public class TelegramMethodBuilder {

	public static SendMessageMethod.SendMessageMethodBuilder sendMessage() {
		return new SendMessageMethod.SendMessageMethodBuilder();
	}
}
