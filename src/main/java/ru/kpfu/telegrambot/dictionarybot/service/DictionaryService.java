package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

public interface DictionaryService {

	DictionaryResponse getResponseWithDescription(String word);
}
