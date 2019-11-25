package ru.kpfu.telegrambot.dictionarybot.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.telegrambot.dictionarybot.entity.User;
import ru.kpfu.telegrambot.dictionarybot.repository.UserRepository;
import ru.kpfu.telegrambot.dictionarybot.state.State;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void setMocks() {
		when(userRepository.getOne(1)).thenReturn(new User(1, State.DICTIONARY));
		when(userRepository.existsById(1)).thenReturn(true);
		when(userRepository.existsById(2)).thenReturn(false);
	}

	@Test
	public void whenUserExist_thenNonNull() {
		User user = userService.retrieveUserIfExistElseSave(1);

		Assert.assertNotNull(user);
	}

	@Test
	public void whenUserNotExist_thenSaveNewUser() {
		User user = userService.retrieveUserIfExistElseSave(2);

		Assert.assertEquals(Integer.valueOf(2), user.getChatId());
		Assert.assertEquals(State.DICTIONARY, user.getState());
	}

}