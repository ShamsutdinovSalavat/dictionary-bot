package ru.kpfu.telegrambot.dictionarybot.utils;

import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.Entry;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.Lexeme;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.LinguaRobotResponse;
import ru.kpfu.telegrambot.dictionarybot.model.dictionary.linguaRobot.Sense;

import java.util.List;

public class ResponseMessageFormatter {

	public static String format(LinguaRobotResponse res) {
		StringBuilder sb = new StringBuilder();
		Entry entry = res.getEntry().get(0);
		String transcription = entry.getPronunciations().get(0).getTranscriptions().get(0).getTranscription();
		List<Lexeme> lexemes = entry.getLexemes();

		sb.append("*" + res.getWord().toUpperCase() + "*  ")
				.append(transcription)
				.append(System.lineSeparator());

		for (Lexeme lexeme : lexemes) {
			sb.append("<" + lexeme.getPartOfSpeech() + ">")
					.append(System.lineSeparator());

			List<Sense> senses = lexeme.getSenses();
			for (int j = 0; j < senses.size() && j < 2; j++) {
				Sense sense = senses.get(j);
				sb.append((j + 1) + ". ");
				sb.append(sense.getDefinition());

				List<String> usageExamples = sense.getUsageExamples();
				if (usageExamples != null) {
					sb.append(System.lineSeparator())
							.append("Ex.: ")
							.append("_" + usageExamples.get(0) + "_");
				}
				sb.append(System.lineSeparator());
			}
			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}
}
