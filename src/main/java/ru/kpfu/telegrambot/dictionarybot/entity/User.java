package ru.kpfu.telegrambot.dictionarybot.entity;

import ru.kpfu.telegrambot.dictionarybot.state.State;

import javax.persistence.*;

@Entity
@Table(name = "tg_user")
public class User {

	@Id
	private Integer chatId;
	@Enumerated(value = EnumType.STRING)
	private State state;

	public User() {
	}

	public User(Integer chatId, State state) {
		this.chatId = chatId;
		this.state = state;
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
