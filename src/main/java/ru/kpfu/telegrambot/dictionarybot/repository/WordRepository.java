package ru.kpfu.telegrambot.dictionarybot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.telegrambot.dictionarybot.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
