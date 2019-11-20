package ru.kpfu.telegrambot.dictionarybot.command;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;
import ru.kpfu.telegrambot.dictionarybot.model.TelegramMessage;
import ru.kpfu.telegrambot.dictionarybot.model.bot.command.LearnSlashCommand;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LearnCommandTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private LearnSlashCommand slashCommand;

	@Test
	public void whenWordsIsempty_thenErrorResponse() {
		when(userRepository.getOne(1)).thenReturn(new User());
		SendMessageMethod response =
				(SendMessageMethod) slashCommand.processCommand(1);

		Assert.assertEquals(TelegramMessage.WORDS_IS_EMPTY_MESSAGE.message(), response.getText());
	}

	@Test
	public void whenUserHasWords_thenOk() {
		User user = new User();
		Word word = new Word();
		word.setWord("word");
		user.setWords(Arrays.asList(word));
		when(userRepository.getOne(2)).thenReturn(new User());

		SendMessageMethod response =
				(SendMessageMethod) slashCommand.processCommand(2);

		Assert.assertThat(response.getText(), StringContains.containsString("word"));

	}
}
