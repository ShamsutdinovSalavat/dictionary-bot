package ru.kpfu.telegrambot.dictionarybot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.telegrambot.dictionarybot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
