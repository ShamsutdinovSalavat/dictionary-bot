package ru.kpfu.telegrambot.dictionarybot.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.SlashCommand;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.TelegramSlashCommandFactory;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.state.State;
import ru.kpfu.telegrambot.dictionarybot.state.StateFactory;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TelegramResponseServiceTest {

	@Mock
	private StateFactory stateFactory;
	@Mock
	private TelegramSlashCommandFactory slashCommandFactory;

	@InjectMocks
	private TelegramResponseServiceImpl service;

	@Test
	public void whenNotSlashCommand_thenDescription() {
		when(stateFactory.getState(State.DICTIONARY))
				.thenReturn((chatId, messageText) ->
						TelegramMethodBuilder.sendMessage()
								.setChatId(1)
								.setText("hello")
								.build());

		SendMessageMethod response =
				(SendMessageMethod) service.getStateResponse(1, "blind", State.DICTIONARY);

		Assert.assertEquals("hello", response.getText());
	}

	@Test
	public void whenSlashCommand_thenSlashCommandMessage() {
		when(slashCommandFactory.getSlashCommand(SlashCommand.START))
				.thenReturn((chatId) ->
						TelegramMethodBuilder.sendMessage()
								.setChatId(1)
								.setText("hello")
								.build());

		SendMessageMethod response =
				(SendMessageMethod) service.getSlashCommandResponse(1, "/start");

		Assert.assertEquals("hello", response.getText());
	}
}
