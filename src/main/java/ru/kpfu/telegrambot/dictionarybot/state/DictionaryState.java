package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;

@Component
public class DictionaryState implements BotState {

	@Autowired
	private DictionaryService dictionaryService;


	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		TelegramResponse response;
		DictionaryResponse dictionaryResponse = dictionaryService.getResponseWithDescription(messageText);

		if (dictionaryResponse != null) {
			response = response(chatId, dictionaryResponse.getDefinition());
		} else {
			response = errorResponse(chatId);
		}

		return response;
	}

	private TelegramResponse response(Integer chatId, String text) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(text)
				.build();
	}

	private TelegramResponse errorResponse(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(TelegramMessage.INCORRECT_WORD_MESSAGE.message())
				.build();
	}
}
