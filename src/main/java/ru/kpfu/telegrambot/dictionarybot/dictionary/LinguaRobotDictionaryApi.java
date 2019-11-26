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
import ru.kpfu.telegrambot.dictionarybot.config.LinguaRobotConfig;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.LinguaRobotResponse;

import static ru.kpfu.telegrambot.dictionarybot.config.LinguaRobotConfig.ENTRIES_METHOD;

@Component("linguaRobotDictionaryApi")
public class LinguaRobotDictionaryApi implements DictionaryApi {

	private static final Logger LOG = LoggerFactory.getLogger(LinguaRobotDictionaryApi.class);

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LinguaRobotConfig config;


	@Override
	public DictionaryResponse getResponseWithDefinition(String word) throws WordNotFoundException {
		HttpEntity<LinguaRobotResponse> httpEntity = new HttpEntity<>(config.getHeaders());
		LOG.debug("Performing request on {}, word = {}", ENTRIES_METHOD, word);

		try {
			ResponseEntity<LinguaRobotResponse> response = restTemplate.exchange(
					ENTRIES_METHOD,
					HttpMethod.GET,
					httpEntity,
					LinguaRobotResponse.class,
					word
			);

			LOG.debug("Response: HttpStatusCode = {}, body = {}", response.getStatusCode(), response.getBody());
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
