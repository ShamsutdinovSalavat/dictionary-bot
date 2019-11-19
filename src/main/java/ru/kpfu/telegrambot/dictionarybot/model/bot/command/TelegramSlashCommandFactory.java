package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;

@Component
public class TelegramSlashCommandFactory {

	private StartSlashCommand startSlashCommand;
	private HelpSlashCommand helpSlashCommand;

	public TelegramSlashCommandFactory(StartSlashCommand startSlashCommand, HelpSlashCommand helpSlashCommand) {
		this.startSlashCommand = startSlashCommand;
		this.helpSlashCommand = helpSlashCommand;
	}

	public TelegramSlashCommand getSlashCommand(SlashCommand command) {
		switch (command) {
			case START:
				return startSlashCommand;
			case HELP:
				return helpSlashCommand;
			default:
				return null;
		}
	}
}
