package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.DictionaryResponse;
import ru.kpfu.telegrambot.dictionarybot.utils.ResponseMessageFormatter;

import java.util.List;

public class LinguaRobotResponse extends DictionaryResponse {
	@JsonProperty("entries")
	private List<Entry> entry;

	public List<Entry> getEntry() {
		return entry;
	}

	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}

	@Override
	public String getDefinition() {
		return entry.get(0)
				.getLexemes().get(0)
				.getSenses().get(0)
				.getDefinition();
	}

	@Override
	public String getDescription() {
		return ResponseMessageFormatter.format(this);
	}

	@Override
	public String getAudioUrl() {
		String resultUrl = "";

		Entry entry = this.entry.get(0);
		List<Pronunciation> pronunciations = entry.getPronunciations();
		if (pronunciations != null) {
			Pronunciation pronunciation = pronunciations.get(0);
			Audio audio = pronunciation.getAudio();
			if (audio != null) {
				resultUrl = audio.getUrl();
			}
		}

		return resultUrl;
	}

	@Override
	public String getWord() {
		return entry.get(0).getEntry();
	}

	@Override
	public String toString() {
		return "LinguaRobotResponse{" +
				"entry=" + entry +
				'}';
	}
}
