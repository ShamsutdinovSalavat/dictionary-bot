package ru.kpfu.telegrambot.dictionarybot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import javax.annotation.PostConstruct;

public abstract class RapidApiConfig {

	@Value("${RAPIDAPI_KEY}")
	protected String key;
	protected HttpHeaders headers = new HttpHeaders();
	private Logger log = LoggerFactory.getLogger(RapidApiConfig.class);

	@PostConstruct
	public void init() {
		setUrlHeader();
		headers.add("x-rapidapi-key", key);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " +
						"Chrome/54.0.2840.99 Safari/537.36");
		log.debug("HEADERS {}", headers);
	}

	protected abstract void setUrlHeader();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
}
