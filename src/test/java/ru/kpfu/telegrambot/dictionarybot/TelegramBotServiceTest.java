package ru.kpfu.telegrambot.dictionarybot;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.telegrambot.dictionarybot.exception.IncorrectMessageException;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Chat;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Message;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;
import ru.kpfu.telegrambot.dictionarybot.service.TelegramBotService;


public class TelegramBotServiceTest {

	private Update update;

	@Before
	public void before() {
		update = new Update();
		Message message = new Message();
		Chat chat = new Chat();
		chat.setId(1);
		message.setChat(chat);
		message.setMessageId(123);
		message.setText("blind");
		update.setMessage(message);
	}

	@Test
	void whenCorrectUpdate_thenReturnSendMessage() throws WordNotFoundException, IncorrectMessageException {
		DictionaryResponse response = Mockito.mock(DictionaryResponse.class);
		DictionaryService dictionaryService = Mockito.mock(DictionaryService.class);
		Mockito.when(response.getDefinition()).thenReturn("unable to see");
		Mockito.when(dictionaryService.getResponseWithDescription("blind")).thenReturn(response);

		TelegramBotService service = new TelegramBotService(dictionaryService);

		SendMessageMethod telegramResponse = (SendMessageMethod) service.getResponse(update);

		Assertions.assertEquals(response.getDefinition(), telegramResponse.getText());
	}
}
