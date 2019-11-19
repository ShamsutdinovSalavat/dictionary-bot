package ru.kpfu.telegrambot.dictionarybot.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi.WordsApiResponse;

import javax.annotation.PostConstruct;

@Component("wordsApi")
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
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " +
						"Chrome/54.0.2840.99 Safari/537.36");
	}


	@Override
	public DictionaryResponse getResponseWithDefinition(String word) throws WordNotFoundException {
		HttpEntity<WordsApiResponse> httpEntity = new HttpEntity<>(headers);
		log.debug("Performing request on {}, word = {}", WORDS_METHOD, word);

		try {
			ResponseEntity<WordsApiResponse> response = restTemplate.exchange(
					WORDS_METHOD,
					HttpMethod.GET,
					httpEntity,
					WordsApiResponse.class,
					word
			);

			log.debug("Response: HttpStatusCode = {}, body = {}", response.getStatusCode(), response.getBody());

			return response.getBody();
		} catch (RestClientException e) {
			throw new WordNotFoundException(e);
		}
	}
}
