package com.gera.hibernate.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS_MESSAGES", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class MessagesEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "MESSAGE", length = 10000, unique = false, nullable = false)
	private String message;
	
	@Column(name = "FROMLOGIN", unique = false, nullable = false)
	private String fromLogin;
	
	@Column(name = "TOLOGIN", unique = false, nullable = false)
	private String toLogin;

	@Column(name = "TIME", unique = false, nullable = false)
	private Calendar timeOfSend;


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFromLogin() {
		return fromLogin;
	}

	public void setFromLogin(String fromLogin) {
		this.fromLogin = fromLogin;
	}

	public String getToLogin() {
		return toLogin;
	}

	public void setToLogin(String toLogin) {
		this.toLogin = toLogin;
	}
	
	public Calendar getTimeOfSend() {
		return timeOfSend;
	}

	public void setTimeOfSend(Calendar timeOfSend) {
		this.timeOfSend = timeOfSend;
	}
	
}
