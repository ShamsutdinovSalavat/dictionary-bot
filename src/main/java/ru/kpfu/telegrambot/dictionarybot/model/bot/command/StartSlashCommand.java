package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;

@Component
public class StartSlashCommand implements TelegramSlashCommand {

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("Welcome to Dictionary Bot!!!")
				.build();
	}
}
