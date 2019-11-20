package ru.kpfu.telegrambot.dictionarybot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

	private final static Logger LOG = LoggerFactory.getLogger(TelegramBotServiceImpl.class);

	@Autowired
	private TelegramResponseService responseService;
	@Autowired
	private UserRepository userRepo;

	@Override
	public TelegramResponse onUpdate(Update update) {
		String text = update.getMessage().getText().toLowerCase();
		Integer chatId = update.getMessage().getChat().getId();
		TelegramResponse response;

		User user = retrieveUserIfExistElseSave(chatId);
		if (isSlashCommand(text)) {
			response = responseService.getSlashCommandResponse(chatId, text);
		} else {
			response = responseService.getStateResponse(chatId, text, user.getState());
		}

		return response;
	}

	private User retrieveUserIfExistElseSave(Integer chatId) {
		User user;
		if (userRepo.existsById(chatId)) {
			LOG.debug("Getting user from db by chatId = {}", chatId);
			user = userRepo.getOne(chatId);
		} else {
			LOG.debug("New user with chatId = {}", chatId);

			user = new User(chatId, State.DICTIONARY);
			userRepo.save(user);
		}

		return user;
	}


	private boolean isSlashCommand(String text) {
		return text.indexOf("/") == 0;
	}

}
