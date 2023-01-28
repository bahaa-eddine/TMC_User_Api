package com.tmc.paca.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import com.tmc.paca.user.exception.BadRequestException;
import com.tmc.paca.user.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Jhon");
        userDTO.setBirthdate(LocalDate.of(2000, 01, 01));
        userDTO.setCountry("France");

        User user = new User();
        userDTO.setName("Jhon");
        user.setBirthdate(LocalDate.of(2000, 01, 01));
        user.setCountry("France");

        when(userMapper.convertToEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        User returnedUser = userService.registerUser(userDTO);

        assertEquals(user, returnedUser);
    }

    @Test
    public void testRegisterUser_UnderAge() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Jhon");
        userDTO.setBirthdate(LocalDate.of(2010, 01, 01));
        userDTO.setCountry("France");

        User user = new User();
        userDTO.setName("Jhon");
        user.setBirthdate(LocalDate.of(2010, 01, 01));
        user.setCountry("France");

        when(userMapper.convertToEntity(userDTO)).thenReturn(user);
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.registerUser(userDTO));
        assertEquals(exception.getErrorMessage(),"User must be 18 years or older.");
    }

    @Test
    public void testRegisterUser_NotFrenchResident() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Jhon");
        userDTO.setBirthdate(LocalDate.of(2000, 01, 01));
        userDTO.setCountry("United States");

        User user = new User();
        userDTO.setName("Jhon");
        user.setBirthdate(LocalDate.of(2000, 01, 01));
        user.setCountry("United States");

        when(userMapper.convertToEntity(userDTO)).thenReturn(user);
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.registerUser(userDTO));
        assertEquals(exception.getErrorMessage(),"User must be resident of France.");
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User returnedUser = userService.getUser(1L);

        assertEquals(user, returnedUser);
    }

    @Test
    public void testGetUser_NotExist() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.getUser(1L));
        assertEquals(exception.getErrorMessage(), String.format("User not exist with this id : %d", user.getId()));
    }
}