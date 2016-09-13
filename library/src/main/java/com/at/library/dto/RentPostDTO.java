package com.at.library.dto;

public class RentPostDTO extends DTO {

	private static final long serialVersionUID = 4629477490797702870L;

	private Integer libro;

	private Integer user;

	private Integer employee;

	public Integer getLibro() {
		return libro;
	}

	public void setLibro(Integer libro) {
		this.libro = libro;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "RentPostDTO [libro=" + libro + ", user=" + user + ", employee=" + employee + "]";
	}

}
