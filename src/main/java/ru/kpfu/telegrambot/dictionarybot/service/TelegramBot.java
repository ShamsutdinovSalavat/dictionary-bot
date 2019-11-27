package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

public interface TelegramBot {
	void send(TelegramResponse response);
}
