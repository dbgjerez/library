package com.at.library.exceptions;

public class UserNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -3777473523291657124L;

	private static final String MSG = "El usuario no existe";

	public UserNotFoundException() {
		super(MSG);
	}

}
