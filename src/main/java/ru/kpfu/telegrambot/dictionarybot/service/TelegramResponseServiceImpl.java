package ru.kpfu.telegrambot.dictionarybot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.TelegramResponse;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.SlashCommand;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.TelegramSlashCommandFactory;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.state.StateFactory;

import java.util.Arrays;


@Service
public class TelegramResponseServiceImpl implements TelegramResponseService {

	@Autowired
	private StateFactory stateFactory;
	@Autowired
	private TelegramSlashCommandFactory slashCommandFactory;

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
			response = errorResponse(chatId);
		}
		return response;
	}

	private TelegramResponse errorResponse(Integer chatId) {
		return TelegramMethodBuilder.sendMessage()
				.setChatId(chatId)
				.setText(TelegramMessage.INCORRECT_WORD_MESSAGE.message())
				.build();
	}

	private boolean isExist(String slashCommand) {
		return Arrays.stream(SlashCommand.values())
				.map(SlashCommand::name)
				.anyMatch(slashCommand::equals);
	}
}
