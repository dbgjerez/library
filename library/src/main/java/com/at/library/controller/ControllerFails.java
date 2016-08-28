package com.at.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.at.library.dto.ApiErrorDTO;
import com.at.library.exceptions.InvalidDataException;
import com.at.library.exceptions.UserNotFoundException;

@ControllerAdvice(basePackages = { "com.at.library.controller" })
public class ControllerFails {

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiErrorDTO error(Exception e) {
		return new ApiErrorDTO(404, e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO error(InvalidDataException e) {
		return new ApiErrorDTO(400, e.getMessage());
	}

}
