package com.gera.login;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if (session == null){
//			response.sendRedirect("index.jsp");
//		}
//		else{
			RequestDispatcher view = request.getRequestDispatcher("success.jsp");
			view.forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
