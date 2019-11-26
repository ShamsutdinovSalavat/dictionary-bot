package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.state.State;

public interface TelegramResponseService {
	TelegramResponse onUpdate(Update update);
	TelegramResponse getSlashCommandResponse(Integer chatId, String messageText);
	TelegramResponse getStateResponse(Integer chatId, String messageText, State state);
}
