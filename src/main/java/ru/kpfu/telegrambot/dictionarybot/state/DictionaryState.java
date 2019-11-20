package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.repository.WordRepository;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;

@Component
public class DictionaryState implements BotState {


	private DictionaryService dictionaryService;
	private WordRepository wordRepository;
	private UserRepository userRepository;

	public DictionaryState(DictionaryService dictionaryService,
	                       WordRepository wordRepository,
	                       UserRepository userRepository) {
		this.dictionaryService = dictionaryService;
		this.wordRepository = wordRepository;
		this.userRepository = userRepository;
	}

	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		TelegramResponse response;
		DictionaryResponse dictionaryResponse = dictionaryService.getResponseWithDescription(messageText);

		if (dictionaryResponse != null) {
			response = response(chatId, dictionaryResponse.getDefinition());
			saveToDb(chatId, dictionaryResponse);
		} else {
			response = errorResponse(chatId);
		}

		return response;
	}


	private void saveToDb(Integer chatId, DictionaryResponse response) {
		Word savedWord = wordRepository.save(new Word(response.getWord(), response.getDefinition()));
		User user = userRepository.getOne(chatId);
		user.addWord(savedWord);
		userRepository.save(user);
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
