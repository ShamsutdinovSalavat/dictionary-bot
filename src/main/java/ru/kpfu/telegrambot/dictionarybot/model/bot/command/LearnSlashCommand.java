package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.service.UserService;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.state.StateFactory;

@Component
public class LearnSlashCommand implements TelegramSlashCommand {

	@Autowired
	private StateFactory stateFactory;
	@Autowired
	private UserService userService;

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		userService.changeState(chatId, State.LEARN);

		return stateFactory.getState(State.LEARN).getResponse(chatId, null);
	}


}
