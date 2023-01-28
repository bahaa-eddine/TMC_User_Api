package com.tmc.paca.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {

    private final String errorMessage;

}
