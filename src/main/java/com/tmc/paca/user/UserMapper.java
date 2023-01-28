package com.tmc.paca.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setCountry(user.getCountry());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setGender(user.getGender());
        return userDTO;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setBirthdate(userDTO.getBirthdate());
        user.setCountry(userDTO.getCountry());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setGender(userDTO.getGender());
        return user;
    }
}