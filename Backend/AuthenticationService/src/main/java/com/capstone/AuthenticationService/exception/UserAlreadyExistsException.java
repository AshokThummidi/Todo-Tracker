package com.capstone.AuthenticationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "OOPS! User already exists.")
public class UserAlreadyExistsException extends Exception{
}
