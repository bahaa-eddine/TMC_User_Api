package com.tmc.paca.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;


public class UserTest {

    @Test
    public void testName() {
        User user = new User("John Doe", LocalDate.of(1990, 1, 1), "USA");
        assertNotNull(user.getName());
        assertFalse(user.getName().isBlank());
    }

    @Test
    public void testBirthdate() {
        User user = new User("John Doe", LocalDate.of(1990, 1, 1), "USA");
        assertNotNull(user.getBirthdate());
    }

    @Test
    public void testCountry() {
        User user = new User("John Doe", LocalDate.of(1990, 1, 1), "USA");
        assertNotNull(user.getCountry());
        assertFalse(user.getCountry().isBlank());
    }

    @Test
    public void testPhoneNumber() {
        User user = new User("John Doe", LocalDate.of(1990, 1, 1), "USA");
        assertNull(user.getPhoneNumber());
    }

    @Test
    public void testGender() {
        User user = new User("John Doe", LocalDate.of(1990, 1, 1), "USA");
        assertNull(user.getGender());
    }
}