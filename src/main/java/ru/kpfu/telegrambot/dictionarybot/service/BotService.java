package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.exception.IncorrectMessageException;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;

public interface BotService {

	TelegramResponse getResponse(Update update) throws IncorrectMessageException, WordNotFoundException;

	TelegramResponse getErrorResponse(Update update);
}
