package ru.kpfu.telegrambot.dictionarybot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.telegrambot.dictionarybot.dictionary.WordsApiDictionaryApi;
import ru.kpfu.telegrambot.dictionarybot.exception.WordNotFoundException;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DictionaryBotApplication.class)
@SpringBootTest(args = {"--wordsapi.key=1234"})
public class WordsApiTest {

	@Autowired
	@Qualifier("api")
	private WordsApiDictionaryApi api;

	@Test
	public void shouldBeOk() throws WordNotFoundException {
		DictionaryResponse response = api.getResponseWithDefinition("start");

		Assert.assertEquals(response.getDefinition(), "get off the ground");
	}

	@Test(expected = WordNotFoundException.class)
	public void shouldThrowWordNotFoundException() throws WordNotFoundException {
		api.getResponseWithDefinition("asdfasdfq");
	}
}
