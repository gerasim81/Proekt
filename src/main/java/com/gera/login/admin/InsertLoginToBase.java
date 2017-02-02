package com.gera.login.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;


public class InsertLoginToBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		HttpSession session = request.getSession(false);
		String method = request.getMethod();
		
		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			String LoginToInsert = request.getParameter("loginToInsert");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			if (password1 == null){
				password1="";
			}
			if (password2 == null){
				password2="";				
			}
			if (LoginToInsert == null || LoginToInsert.equals("")){
				response.sendRedirect("fault3.html");
			}
			else{

				dao = DAOimplHibernate.getInstance();
				List<String> result = dao.getLogins();

				boolean isLoginUsed = false;
				for(String s :result){
					if (LoginToInsert.equals(s)){
						isLoginUsed = true;
					}
				}
				if (!isLoginUsed){
					if (password1.equals(password2)){
						dao.insertLogin(LoginToInsert, password1);
						response.sendRedirect("success.jsp");
					}
					else{
						response.sendRedirect("fault2.html");
					}
				}
				else{
					response.sendRedirect("fault5.html");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
