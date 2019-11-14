package ru.kpfu.telegrambot.dictionarybot.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Objects;

@JsonRootName("from")
public class User {

	private Integer id;

	@JsonProperty("is_bot")
	private boolean isBot;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	private String username;

	@JsonProperty("language_code")
	private String languageCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isIs_bot() {
		return isBot;
	}

	public void setIs_bot(boolean is_bot) {
		this.isBot = is_bot;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return isBot == user.isBot &&
				Objects.equals(id, user.id) &&
				Objects.equals(firstName, user.firstName) &&
				Objects.equals(lastName, user.lastName) &&
				Objects.equals(username, user.username) &&
				Objects.equals(languageCode, user.languageCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isBot, firstName, lastName, username, languageCode);
	}
}
