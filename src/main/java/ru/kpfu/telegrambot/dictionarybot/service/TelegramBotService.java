package ru.kpfu.telegrambot.dictionarybot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Message;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

import java.util.regex.Pattern;

@Service
public class TelegramBotService implements BotService {

	private static final Logger LOG = LoggerFactory.getLogger(TelegramBotService.class);

	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public TelegramResponse getResponse(Update update) {
		Message message = update.getMessage();
		String word = message.getText().toLowerCase();

		if (isCorrectWord(word)) {
			DictionaryResponse dictionaryResponse = dictionaryService.getResponseWithDescription(word);

			return TelegramMethodBuilder
					.sendMessage()
					.setChatId(message.getChat().getId())
					.setText(dictionaryResponse == null ?
							TelegramMessage.INCORRECT_WORD_MESSAGE.value() : dictionaryResponse.getDefinition())
					.build();
		} else {
			return getErrorResponse(update);
		}
	}

	private boolean isCorrectWord(String word) {
		return Pattern.compile("\\w+").matcher(word).matches();
	}

	@Override
	public TelegramResponse getErrorResponse(Update update) {
		return TelegramMethodBuilder
				.sendMessage()
				.setChatId(update.getMessage().getChat().getId())
				.setText(TelegramMessage.INCORRECT_WORD_MESSAGE.value())
				.build();
	}
}
