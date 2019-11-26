package ru.kpfu.telegrambot.dictionarybot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.LinguaRobotResponse;

public class LinguaRobotResponseTest {

	private String json;

	@Before
	public void setJson() {
		json = "{\n" +
				"  \"entries\": [\n" +
				"    {\n" +
				"      \"entry\": \"friend\",\n" +
				"      \"pronunciations\": [\n" +
				"        {\n" +
				"          \"transcriptions\": [\n" +
				"            {\n" +
				"              \"transcription\": \"/fɹɛnd/\",\n" +
				"              \"notation\": \"IPA\"\n" +
				"            },\n" +
				"            {\n" +
				"              \"transcription\": \"[fɹ̥end̥]\",\n" +
				"              \"notation\": \"IPA\"\n" +
				"            }\n" +
				"          ],\n" +
				"          \"audio\": {\n" +
				"            \"url\": \"http://audio.linguarobot.io/en/friend-uk.mp3\",\n" +
				"            \"license\": {\n" +
				"              \"name\": \"BY 3.0 US\",\n" +
				"              \"url\": \"https://creativecommons.org/licenses/by/3.0/us\"\n" +
				"            },\n" +
				"            \"sourceUrl\": \"https://commons.wikimedia.org/w/index.php?curid=9021864\"\n" +
				"          },\n" +
				"          \"context\": {\n" +
				"            \"regions\": [\n" +
				"              \"United Kingdom\"\n" +
				"            ]\n" +
				"          }\n" +
				"        },\n" +
				"        {\n" +
				"          \"transcriptions\": [\n" +
				"            {\n" +
				"              \"transcription\": \"/fɹɛnd/\",\n" +
				"              \"notation\": \"IPA\"\n" +
				"            },\n" +
				"            {\n" +
				"              \"transcription\": \"[fɹ̥end̥]\",\n" +
				"              \"notation\": \"IPA\"\n" +
				"            }\n" +
				"          ],\n" +
				"          \"audio\": {\n" +
				"            \"url\": \"http://audio.linguarobot.io/en/friend-us.mp3\",\n" +
				"            \"license\": {\n" +
				"              \"name\": \"BY-SA 3.0\",\n" +
				"              \"url\": \"https://creativecommons.org/licenses/by-sa/3.0\"\n" +
				"            },\n" +
				"            \"sourceUrl\": \"https://commons.wikimedia.org/w/index.php?curid=857066\"\n" +
				"          },\n" +
				"          \"context\": {\n" +
				"            \"regions\": [\n" +
				"              \"United States\"\n" +
				"            ]\n" +
				"          }\n" +
				"        }\n" +
				"      ],\n" +
				"      \"interpretations\": [\n" +
				"        {\n" +
				"          \"lemma\": \"friend\",\n" +
				"          \"normalizedLemmas\": [\n" +
				"            {\n" +
				"              \"lemma\": \"friend\"\n" +
				"            }\n" +
				"          ],\n" +
				"          \"partOfSpeech\": \"noun\",\n" +
				"          \"grammar\": [\n" +
				"            {\n" +
				"              \"number\": [\n" +
				"                \"singular\"\n" +
				"              ],\n" +
				"              \"case\": [\n" +
				"                \"nominative\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ]\n" +
				"        },\n" +
				"        {\n" +
				"          \"lemma\": \"friend\",\n" +
				"          \"normalizedLemmas\": [\n" +
				"            {\n" +
				"              \"lemma\": \"friend\"\n" +
				"            }\n" +
				"          ],\n" +
				"          \"partOfSpeech\": \"verb\",\n" +
				"          \"grammar\": [\n" +
				"            {\n" +
				"              \"person\": [\n" +
				"                \"first-person\",\n" +
				"                \"second-person\"\n" +
				"              ],\n" +
				"              \"number\": [\n" +
				"                \"singular\"\n" +
				"              ],\n" +
				"              \"verbForm\": [\n" +
				"                \"finite\"\n" +
				"              ],\n" +
				"              \"tense\": [\n" +
				"                \"present\"\n" +
				"              ],\n" +
				"              \"mood\": [\n" +
				"                \"indicative\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"person\": [\n" +
				"                \"first-person\",\n" +
				"                \"second-person\",\n" +
				"                \"third-person\"\n" +
				"              ],\n" +
				"              \"number\": [\n" +
				"                \"plural\"\n" +
				"              ],\n" +
				"              \"verbForm\": [\n" +
				"                \"finite\"\n" +
				"              ],\n" +
				"              \"tense\": [\n" +
				"                \"present\"\n" +
				"              ],\n" +
				"              \"mood\": [\n" +
				"                \"indicative\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"person\": [\n" +
				"                \"first-person\",\n" +
				"                \"second-person\",\n" +
				"                \"third-person\"\n" +
				"              ],\n" +
				"              \"number\": [\n" +
				"                \"singular\",\n" +
				"                \"plural\"\n" +
				"              ],\n" +
				"              \"verbForm\": [\n" +
				"                \"finite\"\n" +
				"              ],\n" +
				"              \"tense\": [\n" +
				"                \"present\"\n" +
				"              ],\n" +
				"              \"mood\": [\n" +
				"                \"subjunctive\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"verbForm\": [\n" +
				"                \"finite\"\n" +
				"              ],\n" +
				"              \"mood\": [\n" +
				"                \"imperative\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"verbForm\": [\n" +
				"                \"infinitive\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ]\n" +
				"        }\n" +
				"      ],\n" +
				"      \"lexemes\": [\n" +
				"        {\n" +
				"          \"lemma\": \"friend\",\n" +
				"          \"partOfSpeech\": \"verb\",\n" +
				"          \"senses\": [\n" +
				"            {\n" +
				"              \"definition\": \"To act as a friend to, to befriend; to be friendly to, to help.\",\n" +
				"              \"labels\": [\n" +
				"                \"obsolete\",\n" +
				"                \"transitive\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"To add (a person) to a list of friends on a social networking site; to officially designate (someone) as a friend.\",\n" +
				"              \"labels\": [\n" +
				"                \"transitive\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"forms\": [\n" +
				"            {\n" +
				"              \"form\": \"friends\",\n" +
				"              \"grammar\": [\n" +
				"                {\n" +
				"                  \"person\": [\n" +
				"                    \"third-person\"\n" +
				"                  ],\n" +
				"                  \"number\": [\n" +
				"                    \"singular\"\n" +
				"                  ],\n" +
				"                  \"verbForm\": [\n" +
				"                    \"finite\"\n" +
				"                  ],\n" +
				"                  \"tense\": [\n" +
				"                    \"present\"\n" +
				"                  ],\n" +
				"                  \"mood\": [\n" +
				"                    \"indicative\"\n" +
				"                  ]\n" +
				"                }\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"form\": \"friending\",\n" +
				"              \"grammar\": [\n" +
				"                {\n" +
				"                  \"verbForm\": [\n" +
				"                    \"participle\"\n" +
				"                  ],\n" +
				"                  \"tense\": [\n" +
				"                    \"present\"\n" +
				"                  ]\n" +
				"                },\n" +
				"                {\n" +
				"                  \"verbForm\": [\n" +
				"                    \"gerund\"\n" +
				"                  ]\n" +
				"                }\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"form\": \"friended\",\n" +
				"              \"grammar\": [\n" +
				"                {\n" +
				"                  \"person\": [\n" +
				"                    \"first-person\",\n" +
				"                    \"second-person\",\n" +
				"                    \"third-person\"\n" +
				"                  ],\n" +
				"                  \"number\": [\n" +
				"                    \"singular\",\n" +
				"                    \"plural\"\n" +
				"                  ],\n" +
				"                  \"verbForm\": [\n" +
				"                    \"finite\"\n" +
				"                  ],\n" +
				"                  \"tense\": [\n" +
				"                    \"past\"\n" +
				"                  ],\n" +
				"                  \"mood\": [\n" +
				"                    \"indicative\"\n" +
				"                  ]\n" +
				"                },\n" +
				"                {\n" +
				"                  \"verbForm\": [\n" +
				"                    \"participle\"\n" +
				"                  ],\n" +
				"                  \"tense\": [\n" +
				"                    \"past\"\n" +
				"                  ]\n" +
				"                }\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"synonymSets\": [\n" +
				"            {\n" +
				"              \"sense\": \"to act as the friend of\",\n" +
				"              \"synonyms\": [\n" +
				"                \"befriend\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"antonymSets\": [\n" +
				"            {\n" +
				"              \"sense\": \"social networking\",\n" +
				"              \"antonyms\": [\n" +
				"                \"unfriend\",\n" +
				"                \"defriend\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ]\n" +
				"        },\n" +
				"        {\n" +
				"          \"lemma\": \"friend\",\n" +
				"          \"partOfSpeech\": \"noun\",\n" +
				"          \"senses\": [\n" +
				"            {\n" +
				"              \"definition\": \"A person other than a family member, spouse or lover whose company one enjoys and towards whom one feels affection.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"John and I have been friends ever since we were roommates at college.   Trust is important between friends.   I used to find it hard to make friends when I was shy.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A boyfriend or girlfriend.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"An associate who provides assistance.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"The Automobile Association is every motorist's friend.   The police is every law-abiding citizen's friend.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A person with whom one is vaguely or indirectly acquainted\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"a friend of a friend;  I added him as a friend on Facebook, but I hardly know him.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A person who backs or supports something.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"I’m not a friend of cheap wine.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"An object or idea that can be used for good.\",\n" +
				"              \"labels\": [\n" +
				"                \"informal\",\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"Wiktionary is your friend.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"Used as a form of address when warning someone.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\",\n" +
				"                \"informal\",\n" +
				"                \"ironic\"\n" +
				"              ],\n" +
				"              \"usageExamples\": [\n" +
				"                \"You’d better watch it, friend.\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A function or class granted special access to the private and protected members of another class.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"context\": {\n" +
				"                \"domains\": [\n" +
				"                  \"computer programming\"\n" +
				"                ]\n" +
				"              }\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A spring-loaded camming device.\",\n" +
				"              \"labels\": [\n" +
				"                \"countable\"\n" +
				"              ],\n" +
				"              \"context\": {\n" +
				"                \"domains\": [\n" +
				"                  \"climbing\"\n" +
				"                ]\n" +
				"              },\n" +
				"              \"usageExamples\": [\n" +
				"                \"Since they were introduced in the 1970s, friends have revolutionized climbing, making protection possible in previously impossible places […] — (Rock Climbing Basics, 1995)\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"definition\": \"A paramour of either sex.\",\n" +
				"              \"labels\": [\n" +
				"                \"obsolete\",\n" +
				"                \"countable\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"forms\": [\n" +
				"            {\n" +
				"              \"form\": \"friends\",\n" +
				"              \"grammar\": [\n" +
				"                {\n" +
				"                  \"number\": [\n" +
				"                    \"plural\"\n" +
				"                  ],\n" +
				"                  \"case\": [\n" +
				"                    \"nominative\"\n" +
				"                  ]\n" +
				"                }\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"synonymSets\": [\n" +
				"            {\n" +
				"              \"sense\": \"person with whom you are acquainted\",\n" +
				"              \"synonyms\": [\n" +
				"                \"contact\",\n" +
				"                \"acquaintance\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"sense\": \"person who provides assistance\",\n" +
				"              \"synonyms\": [\n" +
				"                \"ally\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"sense\": \"person who backs something\",\n" +
				"              \"synonyms\": [\n" +
				"                \"admirer\",\n" +
				"                \"protagonist\",\n" +
				"                \"supporter\",\n" +
				"                \"booster\",\n" +
				"                \"champion\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"sense\": \"form of address used in warning someone\",\n" +
				"              \"synonyms\": [\n" +
				"                \"buster\",\n" +
				"                \"sonny\",\n" +
				"                \"mate\",\n" +
				"                \"pal\",\n" +
				"                \"buddy\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ],\n" +
				"          \"antonymSets\": [\n" +
				"            {\n" +
				"              \"sense\": \"person with whom you are acquainted\",\n" +
				"              \"antonyms\": [\n" +
				"                \"stranger\"\n" +
				"              ]\n" +
				"            },\n" +
				"            {\n" +
				"              \"sense\": \"person who provides assistance\",\n" +
				"              \"antonyms\": [\n" +
				"                \"enemy\",\n" +
				"                \"foe\"\n" +
				"              ]\n" +
				"            }\n" +
				"          ]\n" +
				"        }\n" +
				"      ],\n" +
				"      \"license\": {\n" +
				"        \"name\": \"CC BY-SA 3.0\",\n" +
				"        \"url\": \"https://creativecommons.org/licenses/by-sa/3.0\"\n" +
				"      },\n" +
				"      \"sourceUrls\": [\n" +
				"        \"https://en.wiktionary.org/wiki/friend\"\n" +
				"      ]\n" +
				"    }\n" +
				"  ]\n" +
				"}";
	}

	@Test
	public void allOk() throws JsonProcessingException {
		LinguaRobotResponse response = new ObjectMapper().readValue(json, LinguaRobotResponse.class);

		String js = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response);
	}
}
