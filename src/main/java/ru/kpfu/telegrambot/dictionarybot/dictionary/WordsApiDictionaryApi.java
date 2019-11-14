package ru.kpfu.telegrambot.dictionarybot.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi.WordsApiResponse;

import javax.annotation.PostConstruct;

@Component("api")
public class WordsApiDictionaryApi implements DictionaryApi {

	private static final String URL = "https://wordsapiv1.p.rapidapi.com";
	private static final String WORDS_METHOD = URL + "/words/{word}";
	private static final Logger log = LoggerFactory.getLogger(WordsApiDictionaryApi.class);

	@Value("${wordsapi.key}")
	private String key;

	@Autowired
	private RestTemplate restTemplate;
	private HttpHeaders headers = new HttpHeaders();

	@PostConstruct
	public void init() {
		log.debug("MY KEY: {}", key);
		headers.add("x-rapidapi-host", URL.replace("https://", ""));
		headers.add("x-rapidapi-key", key);
	}


	@Override
	public DictionaryResponse getResponseWithDefinition(String word) throws WordNotFoundException {
		HttpEntity<WordsApiResponse> httpEntity = new HttpEntity<>(headers);
		log.debug("Performing request on {}, word = {}", WORDS_METHOD, word);

		ResponseEntity<WordsApiResponse> response = restTemplate.exchange(
				WORDS_METHOD,
				HttpMethod.GET,
				httpEntity,
				WordsApiResponse.class,
				word
		);

		log.debug("Response: HttpStatusCode = {}, body = {}", response.getStatusCode(), response.getBody());

		if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new WordNotFoundException("Word was not found");
		}

		return response.getBody();
	}
}
