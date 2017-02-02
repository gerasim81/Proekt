package com.gera.model.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gera.model.DAO;

import com.gera.hibernate.HibernateUtil;
import com.gera.hibernate.entity.LoginEntity;
import com.gera.hibernate.entity.MessagesEntity;

public class DAOimplHibernate implements DAO {
	private volatile static DAOimplHibernate dAOimplHibernate;
	
	private DAOimplHibernate(){}
	
	public static DAOimplHibernate getInstance(){
		if (dAOimplHibernate == null){
			synchronized (DAOimplHibernate.class){
				if (dAOimplHibernate == null){
					dAOimplHibernate = new DAOimplHibernate();
				}
			}
		}
		return dAOimplHibernate;		
	}

	public String getPassword(String login) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(LoginEntity.class);
		criteria.add(Restrictions.eq("login", login));
		List<LoginEntity> lst = criteria.list();
		for(LoginEntity ue : lst) {
			if(ue.getLogin().equals(login)) {
				return ue.getPassword();
			}
		}
		return null;
	}
	
	public Integer getId(String login) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(LoginEntity.class);
		criteria.add(Restrictions.eq("login", login));
		List<LoginEntity> lst = criteria.list();
		for(LoginEntity ue : lst) {
			if(ue.getLogin().equals(login)) {
				return ue.getId();
			}
		}
		return null;
	}
	
	
	public List<String> getLogins() {
		
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(LoginEntity.class);
		criteria.addOrder(Order.asc("login"));

		List<LoginEntity> lst = criteria.list();
		
		List<String> logins = new ArrayList<String>();
		for(LoginEntity ue : lst) {
			logins.add(ue.getLogin());
			}
		return logins;
		}
	
	public List<String> getInMessages(String login) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(MessagesEntity.class);
		criteria.add(Restrictions.eq("toLogin", login));
//		criteria.addOrder(Order.asc("id"));
		criteria.addOrder(Order.asc("timeOfSend"));
		
		List<MessagesEntity> lst = criteria.list();

		List<String> inMessagesList = new ArrayList<String>();
		
		for(MessagesEntity ue : lst) {
			int day = ue.getTimeOfSend().get(Calendar.DAY_OF_MONTH);
			int month = ue.getTimeOfSend().get(Calendar.MONTH);
			int year = ue.getTimeOfSend().get(Calendar.YEAR);
			int hours = ue.getTimeOfSend().get(Calendar.HOUR_OF_DAY);
			int minutes = ue.getTimeOfSend().get(Calendar.MINUTE);
			int seconds = ue.getTimeOfSend().get(Calendar.SECOND);
			
			String dayString = zeroAdd(day);
			String monthString = zeroAdd(month+1);
			String hoursString = zeroAdd(hours);
			String minutesString = zeroAdd(minutes);
			String secondsString = zeroAdd(seconds);
						
			String dmy = "от" + " " + dayString + "." + monthString + "." + year + " г.";
			String time = "в" + " " + hoursString + ":" + minutesString + ":" + secondsString;
			
			inMessagesList.add("Сообщение от" + " " + ue.getFromLogin() + " " 
					 + dmy + " " + time + " " + ue.getId());
		}
		return inMessagesList;
	}
		
	private String zeroAdd(int month) {
		String string="";
		if(month < 10){
			string = "0"+ month;
		}
		else{
			string = "" + month;
		}
		return string;
	}

	public List<String> getOutMessages(String login) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(MessagesEntity.class);
		criteria.add(Restrictions.eq("fromLogin", login));
		criteria.addOrder(Order.asc("timeOfSend"));
		List<MessagesEntity> lst = criteria.list();

		List<String> outMessagesList = new ArrayList<String>();
		
		for(MessagesEntity ue : lst) {

			int day = ue.getTimeOfSend().get(Calendar.DAY_OF_MONTH);
			int month = ue.getTimeOfSend().get(Calendar.MONTH);
			int year = ue.getTimeOfSend().get(Calendar.YEAR);
			int hours = ue.getTimeOfSend().get(Calendar.HOUR_OF_DAY);
			int minutes = ue.getTimeOfSend().get(Calendar.MINUTE);
			int seconds = ue.getTimeOfSend().get(Calendar.SECOND);
			
			String dayString = zeroAdd(day);
			String monthString = zeroAdd(month+1);
			String hoursString = zeroAdd(hours);
			String minutesString = zeroAdd(minutes);
			String secondsString = zeroAdd(seconds);
			
			String dmy = "от" + " " + dayString + "." + monthString + "." + year + " г.";
			String time = "в" + " " + hoursString + ":" + minutesString + ":" + secondsString;
								
			outMessagesList.add("Сообщение для" + " " + ue.getToLogin() + " " 
					 + dmy + " " + time + " " + ue.getId());
		}
		return outMessagesList;
	}

	public String getInMessage(String id) {
		
		String message = "";
		Integer msgId = Integer.parseInt(id);
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(MessagesEntity.class);
		criteria.add(Restrictions.eq("id", msgId));
		
		List<MessagesEntity> lst = criteria.list();
		
		for (MessagesEntity ue : lst){
			message = ue.getMessage();
		}
		return message;
	}

	public String getOutMessage(String id) {
		String message = "";
		Integer msgId = Integer.parseInt(id);
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(MessagesEntity.class);
		criteria.add(Restrictions.eq("id", msgId));
		
		List<MessagesEntity> lst = criteria.list();
		
		for (MessagesEntity ue : lst){
			message = ue.getMessage();
		}
		return message;
	}
	
	public void sendMessage(String sendedMessage, String fromLogin, String toLogin) {
		Calendar calendar = Calendar.getInstance();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		MessagesEntity msg = new MessagesEntity();
		msg.setMessage(sendedMessage);
		msg.setFromLogin(fromLogin);
		msg.setToLogin(toLogin);
		msg.setTimeOfSend(calendar);
		
		session.save(msg);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();		
	}
	
	public void insertLogin(String login, String password){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		LoginEntity lgn = new LoginEntity();
		
		lgn.setLogin(login);
		lgn.setPassword(password);
		
		session.save(lgn);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	public void deleteLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		LoginEntity lgn = new LoginEntity();
		
		lgn.setLogin(login);
		Integer id = getId(login);
		String password = getPassword(login);
		lgn.setId(id);
		lgn.setLogin(login);
		lgn.setPassword(password);
		
		session.delete(lgn);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
