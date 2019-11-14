package ru.kpfu.telegrambot.dictionarybot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.wordsapi.WordsApiResponse;

public class WordsApiResponseTest {

	private ObjectMapper mapper = new ObjectMapper();
	private String json;

	@Before
	public void setJson() {
		json = "{\n" +
				"  \"word\": \"valid\",\n" +
				"  \"results\": [\n" +
				"    {\n" +
				"      \"definition\": \"still legally acceptable\",\n" +
				"      \"partOfSpeech\": \"adjective\",\n" +
				"      \"similarTo\": [\n" +
				"        \"unexpired\"\n" +
				"      ],\n" +
				"      \"derivation\": [\n" +
				"        \"validity\",\n" +
				"        \"validness\"\n" +
				"      ],\n" +
				"      \"examples\": [\n" +
				"        \"the license is still valid\"\n" +
				"      ]\n" +
				"    },\n" +
				"    {\n" +
				"      \"definition\": \"well grounded in logic or truth or having legal force\",\n" +
				"      \"partOfSpeech\": \"adjective\",\n" +
				"      \"also\": [\n" +
				"        \"legitimate\",\n" +
				"        \"sensible\",\n" +
				"        \"reasonable\"\n" +
				"      ],\n" +
				"      \"similarTo\": [\n" +
				"        \"logical\",\n" +
				"        \"reasoned\",\n" +
				"        \"sound\",\n" +
				"        \"validated\",\n" +
				"        \"binding\",\n" +
				"        \"well-grounded\",\n" +
				"        \"effectual\",\n" +
				"        \"legal\",\n" +
				"        \"legitimate\"\n" +
				"      ],\n" +
				"      \"antonyms\": [\n" +
				"        \"invalid\"\n" +
				"      ],\n" +
				"      \"derivation\": [\n" +
				"        \"validity\",\n" +
				"        \"validness\"\n" +
				"      ],\n" +
				"      \"examples\": [\n" +
				"        \"a valid inference\",\n" +
				"        \"a valid argument\",\n" +
				"        \"a valid contract\"\n" +
				"      ]\n" +
				"    }\n" +
				"  ],\n" +
				"  \"syllables\": {\n" +
				"    \"count\": 2,\n" +
				"    \"list\": [\n" +
				"      \"val\",\n" +
				"      \"id\"\n" +
				"    ]\n" +
				"  },\n" +
				"  \"pronunciation\": {\n" +
				"    \"all\": \"'vælɪd\"\n" +
				"  },\n" +
				"  \"frequency\": 3.64\n" +
				"}";
	}

	@Test
	public void test() throws JsonProcessingException {
		WordsApiResponse response = mapper.readValue(json, WordsApiResponse.class);
		System.out.println(response);

		Assert.assertThat(response.toString(), StringContains.containsString("vælɪd"));
	}
}
