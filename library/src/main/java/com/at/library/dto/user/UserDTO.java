package com.at.library.dto.user;

public class UserDTO extends UserPostDTO {

	private static final long serialVersionUID = 8359907093177309408L;

	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + "]";
	}

}
