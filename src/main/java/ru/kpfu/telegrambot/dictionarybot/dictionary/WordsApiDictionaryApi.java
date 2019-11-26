package ru.kpfu.telegrambot.dictionarybot.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.telegrambot.dictionarybot.config.WordsApiConfig;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi.WordsApiResponse;

import static ru.kpfu.telegrambot.dictionarybot.config.WordsApiConfig.WORDS_METHOD;

@Component("wordsApiDictionaryApi")
public class WordsApiDictionaryApi implements DictionaryApi {


	private static final Logger LOG = LoggerFactory.getLogger(WordsApiDictionaryApi.class);

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WordsApiConfig config;

	@Override
	public DictionaryResponse getResponseWithDefinition(String word) throws WordNotFoundException {
		HttpEntity<WordsApiResponse> httpEntity = new HttpEntity<>(config.getHeaders());
		LOG.debug("Performing request on {}, word = {}", WORDS_METHOD, word);

		try {
			ResponseEntity<WordsApiResponse> response = restTemplate.exchange(
					WORDS_METHOD,
					HttpMethod.GET,
					httpEntity,
					WordsApiResponse.class,
					word
			);

			LOG.debug("Response: HttpStatusCode = {}, body = {}", response.getStatusCode(), response.getBody());
			return response.getBody();
		} catch (RestClientException e) {
			throw new WordNotFoundException(e);
		}
	}
}
