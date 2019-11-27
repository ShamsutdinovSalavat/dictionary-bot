package ru.kpfu.telegrambot.dictionarybot.model.dictionary;

public abstract class DictionaryResponse {

	public abstract String getDefinition();

	public abstract String getWord();

	public abstract String getDescription();

	public abstract String getAudioUrl();
}
