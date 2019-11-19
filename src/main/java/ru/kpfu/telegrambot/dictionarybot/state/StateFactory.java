package ru.kpfu.telegrambot.dictionarybot.state;

import org.springframework.stereotype.Component;

@Component
public class StateFactory {

	private LearningState learningState;
	private DictionaryState dictionaryState;
	private LearningDialogState learningDialogState;

	public StateFactory(LearningState learningState, DictionaryState dictionaryState, LearningDialogState learningDialogState) {
		this.learningState = learningState;
		this.dictionaryState = dictionaryState;
		this.learningDialogState = learningDialogState;
	}

	public BotState getState(State state) {
		switch (state) {
			case LEARN:
				return learningState;
			case DICTIONARY:
				return dictionaryState;
			case LEARNING_DIALOG:
				return learningDialogState;
			default:
				return null;
		}
	}
}
