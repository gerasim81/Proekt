package com.gera.message;

import java.io.IOException;
//import java.util.List;
//import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;

public class OutMessageShow extends HttpServlet{
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

			String message = request.getParameter("outMessages");
			if (message!= null){
				dao = DAOimplHibernate.getInstance();
				String result = dao.getInMessage(message);
				
				request.setAttribute("outMessage", result);
				RequestDispatcher view5 = 
						request.getRequestDispatcher("view5.jsp");
				view5.forward(request, response);	
			}
			else{
				RequestDispatcher view3 = 
						request.getRequestDispatcher("success.jsp");
				view3.forward(request, response);
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}