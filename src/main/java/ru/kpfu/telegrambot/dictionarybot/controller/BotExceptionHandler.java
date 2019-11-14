package ru.kpfu.telegrambot.dictionarybot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kpfu.telegrambot.dictionarybot.exception.RestException;

@ControllerAdvice
public class BotExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(BotExceptionHandler.class);

	@ExceptionHandler(RestException.class)
	@ResponseBody
	public ResponseEntity handleConflict(RestException exc) {
		LOG.error("", exc);

		return ResponseEntity.ok().build();
	}

}
