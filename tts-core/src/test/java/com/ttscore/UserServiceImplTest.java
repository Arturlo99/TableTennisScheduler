package com.ttscore;

import com.ttscore.controller.UserController;
import com.ttscore.model.User;
import com.ttscore.repository.RoleRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private RoleRepository roleRepository;

	@Mock
	UserService userService;

	@InjectMocks
	private UserController userController;

	private static final String EMAIL = "EMAIL";

	@Test
	void shouldCreateNewUser() {
		//given
		User user = mock(User.class);
		when(user.getEmail()).thenReturn(EMAIL);

		//when

		//then
	}
}
