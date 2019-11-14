package ru.kpfu.telegrambot.dictionarybot;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Chat;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Message;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;
import ru.kpfu.telegrambot.dictionarybot.service.TelegramBotService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TelegramBotServiceTest {

	private Update update = new Update();

	@Mock
	private DictionaryService dictionaryService;

	@InjectMocks
	private TelegramBotService service;

	@Before
	public void before() {
		Message message = new Message();
		Chat chat = new Chat();
		chat.setId(1);
		message.setChat(chat);
		message.setMessageId(123);
		message.setText("blind");
		update.setMessage(message);
	}

	@Test
	public void whenCorrectUpdate_thenReturnSendMessage() {
		when(dictionaryService.getResponseWithDescription("blind"))
				.thenReturn(new DictionaryResponse() {
					@Override
					public String getDefinition() {
						return "unable to see";
					}
				});

		SendMessageMethod telegramResponse = (SendMessageMethod) service.getResponse(update);

		Assertions.assertEquals("unable to see", telegramResponse.getText());
	}
}
