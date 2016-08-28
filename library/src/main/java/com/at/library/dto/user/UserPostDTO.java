package com.at.library.dto.user;

import com.at.library.dto.DTO;

public class UserPostDTO extends DTO {

	private static final long serialVersionUID = -3766236403591774937L;

	protected String dni;

	protected String name;

	public UserPostDTO(String dni, String name) {
		super();
		this.dni = dni;
		this.name = name;
	}

	public UserPostDTO() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserPostDTO [dni=" + dni + ", name=" + name + "]";
	}

}
