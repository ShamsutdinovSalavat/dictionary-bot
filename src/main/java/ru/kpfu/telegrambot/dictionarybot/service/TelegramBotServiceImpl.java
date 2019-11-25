package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

	@Autowired
	private TelegramResponseService responseService;
	@Autowired
	private UserService userService;

	@Override
	public TelegramResponse onUpdate(Update update) {
		String text = update.getMessage().getText().toLowerCase();
		Integer chatId = update.getMessage().getChat().getId();
		TelegramResponse response;

		User user = userService.retrieveUserIfExistElseSave(chatId);
		if (isSlashCommand(text)) {
			response = responseService.getSlashCommandResponse(chatId, text);
		} else {
			response = responseService.getStateResponse(chatId, text, user.getState());
		}

		return response;
	}

	private boolean isSlashCommand(String text) {
		return text.indexOf("/") == 0;
	}

}
