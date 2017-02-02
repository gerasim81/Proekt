package com.gera.login;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class UserFilter implements Filter {


	public UserFilter() {
	}

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp =  (HttpServletResponse) response;

//		String method = httpReq.getMethod();

		HttpSession	session = httpReq.getSession();					
		String loggedIn = "";
		Cookie [] cookies = httpReq.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loggedIn")) {
					if (cookie.getValue().equals(session.getId())) {
						loggedIn = "1";
					}
				}
			}
		}


		if (loggedIn.equals("1")){
			chain.doFilter(request, response);
		}
		else{
			httpResp.sendRedirect("index.jsp");
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
