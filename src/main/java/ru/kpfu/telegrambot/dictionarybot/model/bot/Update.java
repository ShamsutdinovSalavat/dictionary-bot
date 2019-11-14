package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Update {

	@JsonProperty("update_id")
	private Integer updateId;
	private Message message;

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Update)) return false;
		Update update = (Update) o;
		return Objects.equals(updateId, update.updateId) &&
				Objects.equals(message, update.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(updateId, message);
	}

	@Override
	public String toString() {
		return "Update{" +
				"updateId=" + updateId +
				", message=" + message +
				'}';
	}
}
