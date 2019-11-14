package ru.kpfu.telegrambot.dictionarybot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.dictionary.WordsApiDictionaryApi;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	private static final Logger LOG = LoggerFactory.getLogger(DictionaryServiceImpl.class);

	@Autowired
	private WordsApiDictionaryApi wordsApiDictionaryApi;

	@Override
	public DictionaryResponse getResponseWithDescription(String word) {
		DictionaryResponse responseWithDefinition = null;
		try {
			responseWithDefinition = wordsApiDictionaryApi.getResponseWithDefinition(word);
			return responseWithDefinition;
		} catch (WordNotFoundException e) {
			LOG.error("{}", e);
			return responseWithDefinition;
		}
	}
}
