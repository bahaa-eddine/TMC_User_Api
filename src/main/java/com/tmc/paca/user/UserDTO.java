package com.tmc.paca.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private LocalDate birthdate;
    private String country;
    private String phoneNumber;
    private String gender;
    public UserDTO(String name, LocalDate birthdate, String country) {
        this.name = name;
        this.birthdate = birthdate;
        this.country = country;
    }
}