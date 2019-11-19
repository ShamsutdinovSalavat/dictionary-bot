package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

	@Autowired
	private TelegramResponseService responseService;
	@Autowired
	private UserRepository userRepo;

	@Override
	public TelegramResponse onUpdate(Update update) {
		String text = update.getMessage().getText().toLowerCase();
		Integer chatId = update.getMessage().getChat().getId();
		TelegramResponse response;

		if (isSlashCommand(text)) {
			response = responseService.getSlashCommandResponse(chatId, text);
		} else {
			User user = userRepo.getOne(chatId);

			if (user == null) {
				user = new User(chatId, State.DICTIONARY);
				userRepo.save(user);
			}

			response = responseService.getStateResponse(chatId, text, user.getState());
		}

		return response;
	}


	private boolean isSlashCommand(String text) {
		return text.indexOf("/") == 0;
	}

}
