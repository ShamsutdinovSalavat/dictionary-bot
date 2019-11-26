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
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.LinguaRobotResponse;

import javax.annotation.PostConstruct;

@Component("api1")
public class LinguaRobotDictionaryApi implements DictionaryApi {

	private static final String URL = "https://api.linguarobot.io/language/v1/entries/en";
	private static final String WORDS_METHOD = URL + "/{word}";
	private static final Logger log = LoggerFactory.getLogger(LinguaRobotDictionaryApi.class);

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
		HttpEntity<LinguaRobotResponse> httpEntity = new HttpEntity<>(headers);
		log.debug("Performing request on {}, word = {}", WORDS_METHOD, word);

		try {
			ResponseEntity<LinguaRobotResponse> response = restTemplate.exchange(
					WORDS_METHOD,
					HttpMethod.GET,
					httpEntity,
					LinguaRobotResponse.class,
					word
			);

			log.debug("Response: HttpStatusCode = {}, body = {}", response.getStatusCode(), response.getBody());
			LinguaRobotResponse respBody = response.getBody();

			if (respBody.getEntry().isEmpty()) {
				throw new WordNotFoundException("the word is not found");
			}
			return respBody;
		} catch (RestClientException e) {
			throw new WordNotFoundException(e);
		}
	}
}
