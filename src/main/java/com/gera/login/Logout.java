package com.gera.login;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String method = request.getMethod();
		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			if (session != null){
				session.invalidate();
			}
			response.sendRedirect("index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
