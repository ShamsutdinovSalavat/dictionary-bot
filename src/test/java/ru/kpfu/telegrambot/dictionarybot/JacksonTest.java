package ru.kpfu.telegrambot.dictionarybot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.MethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.SendMessageMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JacksonTest {

	@Test
	void updateTest() throws JsonProcessingException {
		String updateJson = "{\n" +
				"    \"update_id\":646911460,\n" +
				"    \"message\":{\n" +
				"        \"message_id\":93,\n" +
				"        \"from\":{\n" +
				"            \"id\":10000,\n" +
				"            \"is_bot\":false,\n" +
				"            \"first_name\":\"Jiayu\",\n" +
				"            \"username\":\"jiayu\",\n" +
				"            \"language_code\":\"en-US\"\n" +
				"        },\n" +
				"        \"chat\":{\n" +
				"            \"id\":10000,\n" +
				"            \"type\":\"private\"\n" +
				"        },\n" +
				"        \"date\":1509641174,\n" +
				"        \"text\":\"eevee\"\n" +
				"    }\n" +
				"}";

		ObjectMapper mapper = new ObjectMapper();

		Update update = mapper.readValue(updateJson, Update.class);

		assertNotNull(update);
		assertThat(update.getUpdateId()).isEqualTo(646911460);
		assertThat(update.getMessage().getMessageId()).isEqualTo(93);
	}


	@Test
	void sendMessageTest() throws JsonProcessingException {
		SendMessageMethod sendMessage = MethodBuilder
				.sendMessage()
				.setChatId(123)
				.setText("KACHIKAWAWA")
				.build();

		String json = new ObjectMapper().writeValueAsString(sendMessage);

		assertNotNull(json);
		assertThat(json)
				.contains("123")
				.doesNotContain("parse_mode");
	}
}
