package ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Context {
	private List<String> regions;

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "Context{" +
				"regions=" + regions +
				'}';
	}
}
