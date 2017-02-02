package com.gera.login;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


import com.gera.model.DAO;
import com.gera.model.impl.DAOimplHibernate;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//	DAO dao = new DAOimplHibernate();
	DAO dao = DAOimplHibernate.getInstance();

	@Override
	public void init() throws ServletException {
		//		getServletContext().setAttribute("DAO", dao);

		boolean adminExists = login("admin", "admin");
		if (!adminExists){
			dao.insertLogin("admin", "admin");
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equals("GET")){
			response.sendRedirect("fault6.html");
		}
		else{
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();

			boolean loginExists = login(login, password);

			if (loginExists){
				Cookie logedInCookie = new Cookie("loggedIn",session.getId());
				logedInCookie.setMaxAge(30*60);
				response.addCookie(logedInCookie);

				if (login.equals("admin")){							
					session.setAttribute("admin","true");
				}

				session.setAttribute("login", login);
				session.setAttribute("password", password);

				if (session.getAttribute("welcomeOnse") == null){
					session.setAttribute("welcomeOnse", "false");
				}

				RequestDispatcher view;
				view = request.getRequestDispatcher("success.jsp");
				view.forward(request, response);

			}	
			else{
				response.sendRedirect("fault.html");
			}
		}
	}		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean login(String login, String pass) {
		String passFrombase = dao.getPassword(login);	
		if(pass.equals(passFrombase)) {
			return true;
		} else {
			return false;
		}
	}
}
