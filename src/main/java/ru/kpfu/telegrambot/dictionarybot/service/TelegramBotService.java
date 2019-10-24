package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Message;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.MethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.exception.IncorrectMessageException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

import java.util.regex.Pattern;

@Service
public class TelegramBotService implements BotService {

	private DictionaryService dictionaryService;

	public TelegramBotService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@Override
	public TelegramResponse getResponse(Update update) throws IncorrectMessageException, WordNotFoundException {
		Message message = update.getMessage();
		String word = message.getText().toLowerCase();

		if (!isCorrectWord(word)) {
			throw new IncorrectMessageException("Message's text is incorrect");
		}

		DictionaryResponse dictionaryResponse = dictionaryService.getResponseWithDescription(word);

		return MethodBuilder.sendMessage()
				.setChatId(message.getChat().getId())
				.setText(dictionaryResponse.getDefinition())
				.build();
	}

	private boolean isCorrectWord(String word) {
		return Pattern.compile("[a-z\\S]+").matcher(word).matches();
	}

	@Override
	public TelegramResponse getErrorResponse() {
		return MethodBuilder
				.sendMessage()
				.setText("kachiwakawa")
				.build();
	}
}
