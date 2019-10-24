package ru.kpfu.telegrambot.dictionarybot.model.bot.method;

public class MethodBuilder {

	public static SendMessageMethod.SendMessageMethodBuilder sendMessage() {
		return new SendMessageMethod.SendMessageMethodBuilder();
	}
}
