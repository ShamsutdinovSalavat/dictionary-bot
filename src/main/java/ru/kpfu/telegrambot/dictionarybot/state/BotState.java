package ru.kpfu.telegrambot.dictionarybot.state;

import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

public interface BotState {
	TelegramResponse getResponse(Integer chatId, String messageText);
}
