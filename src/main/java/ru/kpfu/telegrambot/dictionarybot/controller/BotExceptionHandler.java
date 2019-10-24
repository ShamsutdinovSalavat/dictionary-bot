package ru.kpfu.telegrambot.dictionarybot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.exception.RestException;
import ru.kpfu.telegrambot.dictionarybot.service.BotService;

@ControllerAdvice
public class BotExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(BotExceptionHandler.class);

	private BotService botService;

	public BotExceptionHandler(BotService botService) {
		this.botService = botService;
	}

	@ExceptionHandler(RestException.class)
	@ResponseBody
	public ResponseEntity<TelegramResponse> handleConflict(RestException exc) {
		LOG.error("Exception has occurred: {}", exc);

		TelegramResponse response = botService.getErrorResponse();

		return ResponseEntity.ok(response);
	}

}
