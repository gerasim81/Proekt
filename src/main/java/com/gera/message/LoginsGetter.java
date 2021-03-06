package com.gera.message;

import java.io.IOException;
import java.util.*;
//import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;

public class LoginsGetter extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	DAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
		String method = request.getMethod();
		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			response.setContentType("text/html");

			dao = DAOimplHibernate.getInstance();
			List<String> result = dao.getLogins();
					
			request.setAttribute("logins", result);
			RequestDispatcher view = 
					request.getRequestDispatcher("view.jsp");
			view.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


