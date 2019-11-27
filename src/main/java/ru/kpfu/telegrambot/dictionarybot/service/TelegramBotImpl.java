package ru.kpfu.telegrambot.dictionarybot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendAudioMethod;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;

import javax.annotation.PostConstruct;

@Service
public class TelegramBotImpl implements TelegramBot {

	private static final Logger LOG = LoggerFactory.getLogger(TelegramBotImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${TG_TOKEN}")
	private String token;
	private String url = "https://api.telegram.org/bot";

	@PostConstruct
	private void init() {
		url = url + token;
	}

	@Override
	public void send(TelegramResponse response) {
		if (response instanceof SendMessageMethod) {
			execute(response, TelegramMethod.sendMessage);
		} else if (response instanceof SendAudioMethod) {
			execute(response, TelegramMethod.sendAudio);
		}
	}

	private void execute(TelegramResponse response, TelegramMethod method) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TelegramResponse> httpEntity = new HttpEntity<>(response, httpHeaders);
		ResponseEntity<Update> responseEntity = restTemplate.exchange(
				url + method.getUrl(),
				HttpMethod.POST,
				httpEntity,
				Update.class
		);
		LOG.debug("SendAudio method response: {}", responseEntity.getBody());
	}

	private enum TelegramMethod {
		sendMessage("/sendMessage"), sendAudio("/sendAudio");

		private String url;

		TelegramMethod(String url) {
			this.url = url;
		}

		private String getUrl() {
			return url;
		}
	}
}
