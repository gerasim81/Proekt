<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Страница авторизации</title>
</head>
<body>
<%
	session = request.getSession();
	String loggedIn = "";
	Cookie [] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loggedIn")) {
				if (cookie.getValue().equals(session.getId())) {
					loggedIn = "1";
				}
			}
		}
	}

	if (loggedIn.equals("1")) {
		response.sendRedirect("success.jsp");
	} else {
		out.println("<form action=\"Login\" method=\"post\">");
		out.println("<p><strong>Логин :</strong>"
				+ "<input maxlength=\"25\" size=\"40\" name=\"login\" value=\"\"></p>");
		out.println("<p><strong>Пароль:</strong>"
				+ "<input type=\"password\" maxlength=\"25\" size=\"40\" name=\"password\" value=\"\"></p>");
		out.println("<p><input type=\"submit\" value=\"Войти\"></p></form>");
	}
%>
</body>
</html>