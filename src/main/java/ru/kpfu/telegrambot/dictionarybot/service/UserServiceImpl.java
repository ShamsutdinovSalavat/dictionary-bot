package ru.kpfu.telegrambot.dictionarybot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.repository.WordRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;

@Service
public class UserServiceImpl implements UserService {

	private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WordRepository wordRepository;

	@Override
	public void save(User user) {
		LOG.debug("New user with chatId = {}", user.getChatId());
		userRepository.save(user);
	}

	@Override
	public User retrieveUserIfExistElseSave(Integer chatId) {
		User user = retrieveUser(chatId);
		if (user == null) {
			user = new User(chatId, State.DICTIONARY);
			save(user);
		}

		return user;
	}

	@Override
	public void changeState(Integer chatId, State state) {
		User user = retrieveUserIfExistElseSave(chatId);
		user.setState(state.name());
		save(user);
	}

	@Override
	public void addWord(Integer chatId, Word word) {
		Word savedWord = wordRepository.save(word);
		User user = retrieveUserIfExistElseSave(chatId);
		user.addWord(savedWord);
		save(user);
	}

	private User retrieveUser(Integer chatId) {
		User user = null;
		if (userRepository.existsById(chatId)) {
			LOG.debug("Getting user from db by chatId = {}", chatId);
			user = userRepository.getOne(chatId);
		}

		return user;
	}
}
