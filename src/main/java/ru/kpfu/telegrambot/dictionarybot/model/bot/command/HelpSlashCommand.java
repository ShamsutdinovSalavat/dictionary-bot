package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;

@Component
public class HelpSlashCommand implements TelegramSlashCommand {

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("This is help and here is nothing to say")
				.build();
	}
}
