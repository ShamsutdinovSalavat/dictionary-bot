package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

public interface TelegramSlashCommand {
	TelegramResponse processCommand(Integer chatId);
}
