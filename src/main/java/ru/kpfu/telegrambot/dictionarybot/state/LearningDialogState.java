package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;

@Component
public class LearningDialogState implements BotState {

	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		return null;
	}
}
