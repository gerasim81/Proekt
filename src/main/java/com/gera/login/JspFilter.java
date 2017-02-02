package com.gera.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JspFilter implements Filter {

	public JspFilter() {
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
