package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;

public interface DictionaryService {

	DictionaryResponse getResponseWithDescription(String word) throws WordNotFoundException;
}
