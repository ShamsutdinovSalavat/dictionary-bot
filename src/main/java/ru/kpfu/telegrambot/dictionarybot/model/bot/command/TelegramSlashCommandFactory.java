package ru.kpfu.telegrambot.dictionarybot.model.bot.command;

import org.springframework.stereotype.Component;

@Component
public class TelegramSlashCommandFactory {

	private StartSlashCommand startSlashCommand;
	private HelpSlashCommand helpSlashCommand;
	private LearnSlashCommand learnSlashCommand;
	private StopLearnSlashCommand stopLearnSlashCommand;

	public TelegramSlashCommandFactory(StartSlashCommand startSlashCommand,
	                                   HelpSlashCommand helpSlashCommand,
	                                   LearnSlashCommand learnSlashCommand,
	                                   StopLearnSlashCommand stopLearnSlashCommand) {
		this.startSlashCommand = startSlashCommand;
		this.helpSlashCommand = helpSlashCommand;
		this.learnSlashCommand = learnSlashCommand;
		this.stopLearnSlashCommand = stopLearnSlashCommand;
	}

	public TelegramSlashCommand getSlashCommand(SlashCommand command) {
		switch (command) {
			case START:
				return startSlashCommand;
			case HELP:
				return helpSlashCommand;
			case LEARN:
				return learnSlashCommand;
			case STOPLEARN:
				return stopLearnSlashCommand;
			default:
				return null;
		}
	}
}
