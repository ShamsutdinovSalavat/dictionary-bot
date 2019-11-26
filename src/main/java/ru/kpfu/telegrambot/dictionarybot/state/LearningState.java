package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.KeyboardButton;
import ru.kpfu.telegrambot.dictionarybot.service.UserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.kpfu.telegrambot.dictionarybot.utils.ResponseUtils.*;

@Component
public class LearningState implements BotState {

	@Autowired
	private UserService userService;

	private Map<Integer, String> answers = new HashMap<>();

	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		User user = userService.retrieveUserIfExistElseSave(chatId);
		TelegramResponse response = null;
		if (isNotExistAnswer(chatId)) {
			List<Word> words = user.getWords();
			if (!words.isEmpty()) {
				List<Integer> rands = listOfRands(words.size());
				Word mainWord = words.get(rands.get(0));

				List<List<KeyboardButton>> keyboardButtons = rands.stream()
						.map(i -> words.get(i))
						.map(Word::getDefinition)
						.map(KeyboardButton::new)
						.map(Arrays::asList)
						.collect(Collectors.toList());

				answers.put(chatId, mainWord.getDefinition());
				userService.changeState(user.getChatId(), State.DICTIONARY);

				response = responseWithKeyboard(chatId, mainWord.getWord(), keyboardButtons);
			} else {
				response = errorResponse(chatId, TelegramMessage.WORDS_IS_EMPTY_MESSAGE);
			}

		} else {
			if (answers.get(chatId).equals(messageText)) {
				response = messageResponse(chatId, "Correct!");
			} else {
				response = messageResponse(chatId, "Incorrect!");
			}
			answers.replace(chatId, null);
		}

		return response;
	}

	private boolean isNotExistAnswer(Integer chatId) {
		return !answers.containsKey(chatId) || answers.get(chatId) == null;
	}

	private List<Integer> listOfRands(int range) {
		return Stream.generate(() -> new Random().nextInt(range))
				.distinct()
				.limit(range <= 4 ? range : 4)
				.collect(Collectors.toList());
	}


}
