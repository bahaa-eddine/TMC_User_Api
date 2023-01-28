package com.tmc.paca.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void testRegisterUser() throws Exception {
        UserDTO userDTO = new UserDTO("John Doe", LocalDate.of(2010, 01, 01), "France");
        User user = new User("John Doe", LocalDate.of(2010, 01, 01), "France");
        UserDTO userResponseDTO = new UserDTO("John Doe", LocalDate.of(2010, 01, 01), "France");

        when(userService.registerUser(userDTO)).thenReturn(user);
        when(userMapper.convertToDTO(user)).thenReturn(userResponseDTO);

        String json = objectMapper.writeValueAsString(userDTO);

        mockMvc.perform(post("/users/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.birthdate").value("2010-01-01"))
                .andExpect(jsonPath("$.country").value("France"));

    }
    @Test
    public void testGetUser() throws Exception {
        UserDTO userDTO = new UserDTO("John", LocalDate.of(2010, 01, 01), "France");
        User user = new User("John", LocalDate.of(2010, 01, 01), "France");

        when(userService.getUser(1L)).thenReturn(user);
        when(userMapper.convertToDTO(user)).thenReturn(userDTO);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.birthdate").value("2010-01-01"))
                .andExpect(jsonPath("$.country").value("France"));
    }
}