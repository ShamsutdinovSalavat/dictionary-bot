package ru.kpfu.telegrambot.dictionarybot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.telegrambot.dictionarybot.exception.IncorrectMessageException;
import ru.kpfu.telegrambot.dictionarybot.exception.RestException;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.service.BotService;

import java.util.Objects;

@RestController
@RequestMapping(
		path = "/telegram/webhook",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class BotController {

	private BotService botService;

	public BotController(BotService botService) {
		this.botService = botService;
	}

	@PostMapping
	public ResponseEntity<TelegramResponse> update(Update update) throws RestException {

		if (Objects.isNull(update)) {
			throw new RestException("Update is null");
		}

		try {
			TelegramResponse response = botService.getResponse(update);
			return ResponseEntity.ok(response);

		} catch (IncorrectMessageException | WordNotFoundException ex) {
			throw new RestException(ex);
		}
	}
}
