package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Objects;

@JsonRootName("message")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	@JsonProperty("message_id")
	private Integer messageId;
	@JsonProperty("from")
	private User user;
	private Chat chat;
	private String text;


	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Message)) return false;
		Message message = (Message) o;
		return Objects.equals(messageId, message.messageId) &&
				Objects.equals(user, message.user) &&
				Objects.equals(chat, message.chat) &&
				Objects.equals(text, message.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(messageId, user, chat, text);
	}
}
