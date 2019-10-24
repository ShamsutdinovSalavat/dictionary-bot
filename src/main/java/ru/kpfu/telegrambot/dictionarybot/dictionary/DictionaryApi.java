package ru.kpfu.telegrambot.dictionarybot.dictionary;

import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;

public interface DictionaryApi {

	DictionaryResponse getResponseWithDefinition(String word) throws WordNotFoundException;
}
