package ru.kpfu.telegrambot.dictionarybot.utils;

import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.KeyboardButton;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

import java.util.List;

public class ResponseUtils {

	public static TelegramResponse messageResponse(Integer chatId, String message) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(message)
				.setParseMode("markdown")
				.build();
	}

	public static TelegramResponse audioResponse(Integer chatId, DictionaryResponse dictionaryResponse) {
		return TelegramMethodBuilder.sendAudio()
				.setChatId(chatId)
				.setAudio(dictionaryResponse.getAudioUrl())
				.setCaption(dictionaryResponse.getDescription())
				.setParseMode("markdown")
				.setTitle("pronunciation")
				.build();
	}

	public static TelegramResponse errorResponse(Integer chatId, TelegramMessage telegramMessage) {
		return messageResponse(chatId, telegramMessage.message());
	}

	public static TelegramResponse responseWithKeyboard(Integer chatId, String word, List<List<KeyboardButton>> buttons) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("Choose correct definition of \"" + word + "\"")
				.setReplyMarkup()
				.setOneTimeKeyboard(true)
				.setResizeKeyboard(false)
				.setKeyboard(buttons)
				.build()
				.build();
	}
}
