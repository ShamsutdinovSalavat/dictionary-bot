package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;

public interface TelegramBotService {
	TelegramResponse onUpdate(Update update);
}
