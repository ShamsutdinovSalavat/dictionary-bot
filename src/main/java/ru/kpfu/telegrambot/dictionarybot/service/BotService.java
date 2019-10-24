package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.exception.IncorrectMessageException;

public interface BotService {

	TelegramResponse getResponse(Update update) throws IncorrectMessageException, WordNotFoundException;
	TelegramResponse getErrorResponse();
}
