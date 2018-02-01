package com.at.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RentPK implements Serializable {

	private static final long serialVersionUID = -5371004252314610602L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date init;

	@OneToOne
	private Book book;

	public Date getInit() {
		return init;
	}

	public void setInit(Date init) {
		this.init = init;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
