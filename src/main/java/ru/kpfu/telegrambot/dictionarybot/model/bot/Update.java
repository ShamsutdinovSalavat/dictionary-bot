package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	public String toString() {
		return "Update{" +
				"updateId=" + updateId +
				", message=" + message +
				'}';
	}
}
