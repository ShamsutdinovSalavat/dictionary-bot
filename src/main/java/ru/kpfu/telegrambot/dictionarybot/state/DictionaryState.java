package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;
import ru.kpfu.telegrambot.dictionarybot.service.TelegramBot;
import ru.kpfu.telegrambot.dictionarybot.service.UserService;

import static ru.kpfu.telegrambot.dictionarybot.utils.ResponseUtils.*;

@Component
public class DictionaryState implements BotState {

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private TelegramBot telegramBot;
	@Autowired
	private UserService userService;


	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		TelegramResponse response;
		DictionaryResponse dictionaryResponse = dictionaryService.getResponseWithDescription(messageText);

		if (dictionaryResponse != null) {
			String audioUrl = dictionaryResponse.getAudioUrl();
			if (!audioUrl.isEmpty()) {
				telegramBot.send(audioResponse(chatId, dictionaryResponse));
			}

			response = messageResponse(chatId, dictionaryResponse.getDescription());
			userService.addWord(chatId, new Word(dictionaryResponse.getWord(), dictionaryResponse.getDefinition()));
		} else {
			response = errorResponse(chatId, TelegramMessage.INCORRECT_WORD_MESSAGE);
		}

		return response;
	}
}
