package ru.kpfu.telegrambot.dictionarybot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.telegrambot.dictionarybot.exception.RestException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.service.TelegramResponseService;

@RestController
@RequestMapping(
		path = "/telegram/webhook",
		consumes = "application/json"
)
public class BotController {

	private static final Logger LOG = LoggerFactory.getLogger(BotController.class);

	@Autowired
	private TelegramResponseService responseService;


	@PostMapping
	public ResponseEntity<TelegramResponse> update(@RequestBody Update update) throws RestException {
		LOG.debug("Incomming update: {}", update);

		if (update == null && update.getMessage().getText() == null) {
			throw new RestException("Update is null");
		}

		try {
			TelegramResponse response = responseService.onUpdate(update);
			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			throw new RestException(ex);
		}
	}
}
