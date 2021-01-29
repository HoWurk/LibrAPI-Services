package com.ghostdovahkiin.LibrApi.user.services;

import com.ghostdovahkiin.LibrApi.exceptions.UserNotFoundException;
import com.ghostdovahkiin.LibrApi.user.User;
import com.ghostdovahkiin.LibrApi.user.UserRepository;
import com.ghostdovahkiin.LibrApi.user.services.ListOneUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static com.ghostdovahkiin.LibrApi.user.services.builders.UserBuilder.createUser;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests execution for List One User Service")
class ListOneUserServiceTest {

    @Mock
    private UserRepository userRepository;
    private ListOneUserServiceImpl listOneUserService;

    @BeforeEach
    void setUp() { this.listOneUserService = new ListOneUserServiceImpl(userRepository); }

    @Test
    @DisplayName("Should return one user")
    void shouldFindOneUser(){
        User userBuild = createUser().build();
        Optional<User> userSaved = Optional.of(userBuild);

        when(userRepository.findById(anyLong())).thenReturn(userSaved);
        User userResult = listOneUserService.findById(1L);

        assertAll("User",
                () -> assertThat(userResult.getName(), is(userBuild.getName())),
                () -> assertThat(userResult.getAge(), is(userBuild.getAge())),
                () -> assertThat(userResult.getEmail(), is(userBuild.getEmail())),
                () -> assertThat(userResult.getPhone(), is(userBuild.getPhone())),
                () -> assertThat(userResult.getSex(), is(userBuild.getSex()))
        );

    }

    @Test
    @DisplayName("Shold return a UserNotFoundException if not encountered a user with specified ID")
    void shouldThrowUserNotFoundException() {
        when(userRepository.findById(anyLong())).thenThrow(new UserNotFoundException());
        assertThrows(UserNotFoundException.class, () -> userRepository.findById(1l));
        verify(userRepository, times(1)).findById(anyLong());
    }
}
