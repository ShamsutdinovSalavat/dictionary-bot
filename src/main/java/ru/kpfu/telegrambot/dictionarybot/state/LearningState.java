package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.KeyboardButton;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LearningState implements BotState {

	@Autowired
	private UserRepository userRepository;
	private Map<Integer, String> answers = new HashMap<>();


	@Override
	public TelegramResponse getResponse(Integer chatId, String messageText) {
		User user = userRepository.getOne(chatId);
		if (!answers.containsKey(chatId) || answers.get(chatId) == null) {
			List<Word> words = user.getWords();
			if (!words.isEmpty()) {
				List<Integer> rands = listOfRands(words.size());
				Word mainWord = words.get(rands.get(0));

				List<KeyboardButton> keyboardButtons = rands.stream()
						.map(i -> words.get(i))
						.map(Word::getDefinition)
						.map(KeyboardButton::new)
						.collect(Collectors.toList());

				answers.put(chatId, mainWord.getDefinition());

				return response(chatId, mainWord.getWord(), keyboardButtons);
			} else {
				return errorResponse(chatId);
			}

		} else {
			String answer = answers.get(chatId);
			TelegramResponse response;
			if (answer.equals(messageText)) {
				response = correctAnswer(chatId);

			} else {
				response = incorrectAnswer(chatId);
			}
			answers.replace(chatId, null);

			return response;
		}
	}

	private List<Integer> listOfRands(int range) {
		return Stream.generate(() -> new Random().nextInt(range))
				.distinct()
				.limit(range <= 4 ? range : 4)
				.collect(Collectors.toList());
	}

	private TelegramResponse correctAnswer(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("Correct!")
				.build();
	}

	private TelegramResponse incorrectAnswer(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("Incorrect!")
				.build();
	}

	private TelegramResponse response(Integer chatId, String word, List<KeyboardButton> buttons) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText("Choose correct definition of \"" + word + "\"")
				.setReplyMarkup()
				.setOneTimeKeyboard(true)
				.setResizeKeyboard(true)
				.setKeyboard(buttons)
				.build()
				.build();
	}

	private TelegramResponse errorResponse(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(TelegramMessage.WORDS_IS_EMPTY_MESSAGE.message())
				.build();
	}
}
