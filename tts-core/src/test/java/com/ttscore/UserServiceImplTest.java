package com.ttscore;

import com.ttscore.dto.CredentialsDTO;
import com.ttscore.model.Role;
import com.ttscore.model.User;
import com.ttscore.repository.RoleRepository;
import com.ttscore.repository.UserRepository;
import com.ttscore.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    UserServiceImpl userService;

    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private static final String ROLE_USER = "ROLE_USER";
    private static final String LOGGED_IN = "loggedIn";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String ROLE = "role";
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer ROLE_USER_ID = 2;

    @Test
    void shouldCreateNewUser() {
        //given
        Role role = new Role();
        role.setName(ROLE_USER);
        User user = new User();
        user.setEmail(EMAIL);
        when(userRepository.countUsingEmail(user.getEmail())).thenReturn(ZERO);
        when(roleRepository.getById(ROLE_USER_ID)).thenReturn(role);

        //when
        ResponseEntity<?> result = userService.createNewUser(user);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(user.getRole()).isEqualTo(role);
        verify(userRepository).save(user);
    }

    @Test
    void shouldNotCreateNewUser() {
        //given
        User user = mock(User.class);
        when(userRepository.countUsingEmail(user.getEmail())).thenReturn(ONE);

        //when
        ResponseEntity<?> result = userService.createNewUser(user);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
        verify(userRepository, never()).save(user);
    }

    @Test
    void shouldLogin() {
        //given
        CredentialsDTO credentialsDTO = mock(CredentialsDTO.class);
        User user = mock(User.class);
        Role role = mock(Role.class);
        when(userRepository.findUserByEmail(credentialsDTO.getEmail())).thenReturn(user);
        when(user.getPassword()).thenReturn(PASSWORD);
        when(user.getRole()).thenReturn(role);
        when(role.getName()).thenReturn(ROLE_USER);
        when(credentialsDTO.getPassword()).thenReturn(PASSWORD);

        //when
        Map<String, String> result = userService.login(credentialsDTO);

        //then
        Assertions.assertThat(result).containsOnly(Map.entry(LOGGED_IN, TRUE), Map.entry(ROLE, ROLE_USER));
    }

    @Test
    void shouldNotLogin() {
        //given
        CredentialsDTO credentialsDTO = mock(CredentialsDTO.class);
        User user = mock(User.class);
        when(userRepository.findUserByEmail(credentialsDTO.getEmail())).thenReturn(user);
        when(user.getPassword()).thenReturn(PASSWORD);
        when(credentialsDTO.getPassword()).thenReturn(null);

        //when
        Map<String, String> result = userService.login(credentialsDTO);

        //then
        Assertions.assertThat(result).containsOnly(Map.entry(LOGGED_IN, FALSE));
    }

    @Test
    void shouldNotLoginAndReturnEmptyMap() {
        //given
        CredentialsDTO credentialsDTO = mock(CredentialsDTO.class);
        when(userRepository.findUserByEmail(credentialsDTO.getEmail())).thenReturn(null);

        //when
        Map<String, String> result = userService.login(credentialsDTO);

        //then
        Assertions.assertThat(result).isEmpty();
    }
}
