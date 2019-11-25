package ru.kpfu.telegrambot.dictionarybot.service;

import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.state.State;

public interface UserService {
	void save(User user);

	User retrieveUserIfExistElseSave(Integer chatId);

	void changeState(Integer chatId, State state);

	void addWord(Integer chatId, Word word);
}
