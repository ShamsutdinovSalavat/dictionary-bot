package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.KeyboardButton;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;

import java.util.List;
import java.util.Random;

@Component
public class LearnSlashCommand implements TelegramSlashCommand {

	private UserRepository userRepository;

	@Override
	public TelegramResponse processCommand(Integer chatId) {
		User user = userRepository.getOne(chatId);
		List<Word> words = user.getWords();

		if (!words.isEmpty()) {
			int range = words.size();
			int randIndex = new Random().nextInt(range);
			Word word = words.get(randIndex);

			return TelegramMethodBuilder.sendMessage()
					.setChatId(chatId)
					.setText("Choise correct definition of " + word)
					.setReplyMarkup()
					.setOneTimeKeyboard(true)
					.setResizeKeyboard(true)
					.addKeyboardButton(new KeyboardButton("hello"))
					.addKeyboardButton(new KeyboardButton("hello2"))
					.addKeyboardButton(new KeyboardButton("hello3"))
					.build()
					.build();
		} else {
			return errorResponse(chatId);
		}
	}

	private TelegramResponse errorResponse(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(TelegramMessage.WORDS_IS_EMPTY_MESSAGE.message())
				.build();
	}
}
