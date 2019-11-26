package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.utils.ResponseUtils;

@Component
public class StartSlashCommand implements TelegramSlashCommand {

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		return ResponseUtils.messageResponse(chatId, "Welcome to Dictionary Bot!!!");
	}
}
