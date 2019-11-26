package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.utils.ResponseUtils;

@Component
public class StopLearnSlashCommand implements TelegramSlashCommand {

	@Autowired
	private UserRepository userRepository;

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		User user = userRepository.getOne(chatId);
		user.setState(State.DICTIONARY.name());

		userRepository.save(user);
		return ResponseUtils.messageResponse(chatId, "Learning has been stopped!");
	}
}
