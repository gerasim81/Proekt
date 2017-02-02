package com.gera.login.admin;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;


public class DeleteLoginFromBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
		String method = request.getMethod();

		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			String LoginToDelete = request.getParameter("loginToDelete");
			if (LoginToDelete == null){
				response.sendRedirect("fault4.html");
			}
			else{
				dao = DAOimplHibernate.getInstance();
				dao.deleteLogin(LoginToDelete);
				response.sendRedirect("success.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
