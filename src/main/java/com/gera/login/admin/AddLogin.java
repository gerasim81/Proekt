package com.gera.login.admin;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;

public class AddLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;

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

			RequestDispatcher view;
			view = request.getRequestDispatcher("added.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
