package com.tmc.paca.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Attribut name must not be null")
    @NotBlank(message = "Attribut name is required")
    private String name;
    @NotNull(message = "Attribut birthdate must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @NotNull(message = "Attribut country must not be null")
    @NotBlank(message = "Attribut country is required")
    private String country;
    private String phoneNumber;
    private String gender;

    public User(String name, LocalDate birthdate, String country) {
        this.name = name;
        this.birthdate = birthdate;
        this.country = country;
    }
}