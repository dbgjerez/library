package com.at.library.exceptions;

public class UserNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -3777473523291657124L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
