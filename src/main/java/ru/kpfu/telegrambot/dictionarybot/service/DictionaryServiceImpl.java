package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Override
	public DictionaryResponse getResponseWithDescription(String word) throws WordNotFoundException {
		return new DictionaryResponse() {
			@Override
			public String getDefinition() {
				return "HELLO";
			}
		};
	}
}
