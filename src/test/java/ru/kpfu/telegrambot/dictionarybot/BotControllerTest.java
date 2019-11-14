package ru.kpfu.telegrambot.dictionarybot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.kpfu.telegrambot.dictionarybot.model.bot.Update;
import ru.kpfu.telegrambot.dictionarybot.model.bot.method.TelegramMethodBuilder;
import ru.kpfu.telegrambot.dictionarybot.service.DictionaryServiceImpl;
import ru.kpfu.telegrambot.dictionarybot.service.TelegramBotService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BotControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TelegramBotService service;
	@MockBean
	private DictionaryServiceImpl dicService;

	private String json;
	private Update update;

	@Before
	public void setJson() throws JsonProcessingException {
		json = "{\n" +
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
		update = new ObjectMapper().readValue(json, Update.class);
	}

	@Test
	public void whenCorrectUpdate_thenHttpOk() throws Exception {
		when(service.getResponse(update)).thenReturn(
				TelegramMethodBuilder.sendMessage()
						.setText("hello")
						.build());

		this.mockMvc
				.perform(
						post("/telegram/webhook")
								.contentType("application/json")
								.content(json))
				.andExpect(status().isOk());
	}
}
