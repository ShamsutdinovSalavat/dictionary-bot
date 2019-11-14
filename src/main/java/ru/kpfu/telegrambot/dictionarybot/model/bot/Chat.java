package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Objects;

@JsonRootName("chat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat {

	private Integer id;
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Chat)) return false;
		Chat chat = (Chat) o;
		return Objects.equals(id, chat.id) &&
				Objects.equals(type, chat.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}
}
