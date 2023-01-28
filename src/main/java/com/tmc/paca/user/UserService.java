package com.tmc.paca.user;

import com.tmc.paca.user.exception.BadRequestException;
import com.tmc.paca.user.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User registerUser(UserDTO userDTO) throws BadRequestException {
        User user = userMapper.convertToEntity(userDTO);
        if (!isAdult(user.getBirthdate())){
            throw new BadRequestException("User must be 18 years or older.");
        }
        if (!isFrenchResident(user.getCountry())) {
            throw new BadRequestException("User must be resident of France.");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException(String.format("User not exist with this id : %d", id));
        }
        return user;
    }

    private boolean isAdult(LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthdate, today);
        return age.getYears() >= 18;
    }

    private boolean isFrenchResident(String country) {
        return "France".equalsIgnoreCase(country);
    }
}