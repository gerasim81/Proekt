package com.gera.message;

import java.io.IOException;
import java.util.List;
//import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;

public class OutMessageSelector extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	DAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String method = request.getMethod();
		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			String login = (String) session.getAttribute("login");
			
			dao = DAOimplHibernate.getInstance();
			List<String> result = dao.getOutMessages(login);
			
			request.setAttribute("outMessages", result);
			RequestDispatcher view2 = 
					request.getRequestDispatcher("view4.jsp");
			view2.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}