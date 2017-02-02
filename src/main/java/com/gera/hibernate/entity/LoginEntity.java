package com.gera.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LOGIN", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "LOGIN")})
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;	

	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;
	
	@Column(name = "PASSWORD", unique = false, nullable = false)
	private String password;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
