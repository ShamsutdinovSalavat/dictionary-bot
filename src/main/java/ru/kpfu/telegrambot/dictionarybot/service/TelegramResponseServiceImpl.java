package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.SlashCommand;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.TelegramSlashCommandFactory;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.state.StateFactory;

import java.util.Arrays;

import static ru.kpfu.telegrambot.dictionarybot.utils.ResponseUtils.errorResponse;


@Service
public class TelegramResponseServiceImpl implements TelegramResponseService {

	@Autowired
	private StateFactory stateFactory;
	@Autowired
	private TelegramSlashCommandFactory slashCommandFactory;
	@Autowired
	private UserService userService;

	@Override
	public TelegramResponse onUpdate(Update update) {
		String text = update.getMessage().getText().toLowerCase();
		Integer chatId = update.getMessage().getChat().getId();
		TelegramResponse response;

		User user = userService.retrieveUserIfExistElseSave(chatId);
		if (isSlashCommand(text)) {
			response = getSlashCommandResponse(chatId, text);
		} else {
			response = getStateResponse(chatId, text, user.getState());
		}

		return response;
	}

	private boolean isSlashCommand(String text) {
		return text.indexOf("/") == 0;
	}

	@Override
	public TelegramResponse getStateResponse(Integer chatId, String messageText, State state) {
		return stateFactory.getState(state).getResponse(chatId, messageText);
	}

	@Override
	public TelegramResponse getSlashCommandResponse(Integer chatId, String messageText) {
		TelegramResponse response;

		String slashCommand = messageText.toLowerCase().replace("/", "").toUpperCase();
		if (isExist(slashCommand)) {
			response = slashCommandFactory
					.getSlashCommand(SlashCommand.valueOf(slashCommand))
					.processCommand(chatId);
		} else {
			response = errorResponse(chatId, TelegramMessage.INCORRECT_WORD_MESSAGE);
		}
		return response;
	}

	private boolean isExist(String slashCommand) {
		return Arrays.stream(SlashCommand.values())
				.map(SlashCommand::name)
				.anyMatch(slashCommand::equals);
	}
}
