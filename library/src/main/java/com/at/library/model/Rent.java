package com.at.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = -4158742374158942716L;

	@EmbeddedId
	private RentPK pk;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	public RentPK getPk() {
		return pk;
	}

	public void setPk(RentPK pk) {
		this.pk = pk;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
