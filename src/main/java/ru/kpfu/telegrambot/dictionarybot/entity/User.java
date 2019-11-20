package ru.kpfu.telegrambot.dictionarybot.entity;

import ru.kpfu.telegrambot.dictionarybot.state.State;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tg_user")
public class User {

	@Id
	private Integer chatId;

	@Enumerated(value = EnumType.STRING)
	private State state;

	@OneToMany(targetEntity = Word.class)
	private List<Word> words = new ArrayList<>();

	public User() {
	}

	public User(Integer chatId, State state) {
		this.chatId = chatId;
		this.state = state;
	}

	public void addWord(Word word) {
		words.add(word);
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public State getState() {
		return state;
	}

	public void setState(String state) {
		this.state = State.valueOf(state);
	}
}
