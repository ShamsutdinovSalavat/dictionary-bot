package ru.kpfu.telegrambot.dictionarybot.state;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryService;
import ru.kpfu.telegrambot.dictionarybot.service.UserService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryStateTest {

	@Mock
	private DictionaryService dictionaryService;
	@Mock
	private UserService userService;
	@InjectMocks
	private DictionaryState dictionaryState;

	@Test
	public void whenNotCorrect_thenErrorResponse() {
		when(dictionaryService.getResponseWithDescription("qwerty"))
				.thenReturn(null);

		SendMessageMethod response =
				(SendMessageMethod) dictionaryState.getResponse(1, "qwerty");

		Assert.assertEquals(TelegramMessage.INCORRECT_WORD_MESSAGE.message(), response.getText());
	}

	@Test
	public void whenNotSlashCommand_thenDescription() {
		when(dictionaryService.getResponseWithDescription("blind"))
				.thenReturn(new DictionaryResponse() {
					@Override
					public String getDefinition() {
						return "unable to see";
					}

					@Override
					public String getWord() {
						return "blind";
					}

					@Override
					public String getDescription() {
						return null;
					}

					@Override
					public String getAudioUrl() {
						return null;
					}
				});

		SendMessageMethod response =
				(SendMessageMethod) dictionaryState.getResponse(1, "blind");

		Assert.assertEquals("unable to see", response.getText());
	}
}
