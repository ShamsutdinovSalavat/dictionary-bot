package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.state.StateFactory;

@Component
public class LearnSlashCommand implements TelegramSlashCommand {

	private StateFactory stateFactory;
	private UserRepository userRepository;

	public LearnSlashCommand(StateFactory stateFactory, UserRepository userRepository) {
		this.stateFactory = stateFactory;
		this.userRepository = userRepository;
	}

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		User user = userRepository.getOne(chatId);
		user.setState(State.LEARN.name());
		userRepository.save(user);

		return stateFactory.getState(State.LEARN).getResponse(chatId, null);
	}


}
