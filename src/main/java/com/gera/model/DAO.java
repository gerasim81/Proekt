package com.gera.model;

import java.util.List;

public interface DAO {

	String getPassword(String login);
	Integer getId(String login);
	List<String> getLogins();
	List<String> getInMessages(String login);
	List<String> getOutMessages(String login);
	String getInMessage(String id);
	String getOutMessage(String id);
	void sendMessage(String sendedMessage, String fromLogin, String toLogin);
	void insertLogin(String login, String password);
	void deleteLogin(String login);
	
}
