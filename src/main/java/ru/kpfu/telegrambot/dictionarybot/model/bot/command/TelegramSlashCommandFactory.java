package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;

@Component
public class TelegramSlashCommandFactory {

	private StartSlashCommand startSlashCommand;
	private HelpSlashCommand helpSlashCommand;
	private LearnSlashCommand learnSlashCommand;

	public TelegramSlashCommandFactory(StartSlashCommand startSlashCommand,
	                                   HelpSlashCommand helpSlashCommand,
	                                   LearnSlashCommand learnSlashCommand) {
		this.startSlashCommand = startSlashCommand;
		this.helpSlashCommand = helpSlashCommand;
		this.learnSlashCommand = learnSlashCommand;
	}

	public TelegramSlashCommand getSlashCommand(SlashCommand command) {
		switch (command) {
			case START:
				return startSlashCommand;
			case HELP:
				return helpSlashCommand;
			case LEARN:
				return learnSlashCommand;
			default:
				return null;
		}
	}
}
