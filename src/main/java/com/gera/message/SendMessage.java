package com.gera.message;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;


public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String method = request.getMethod();
		if (method.equals("GET")){
			response.sendRedirect("success.jsp");
		}
		else{
			request.setCharacterEncoding("UTF-8");//
			String sendedMessage =  request.getParameter("sendedMessage");
			String toLogin = request.getParameter("loginToSend");
			String fromLogin = (String) session.getAttribute("login");
			if (sendedMessage == null | toLogin == null | fromLogin == null){
			}
			else{
				dao = DAOimplHibernate.getInstance();
				dao.sendMessage(sendedMessage, fromLogin, toLogin);
			}
			response.sendRedirect("success.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
