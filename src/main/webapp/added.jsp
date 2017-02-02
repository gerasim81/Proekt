<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Добавить логин</title>
</head>
<body>
	<%
		if (((String) session.getAttribute("admin")) == null) {
			response.sendRedirect("success.jsp");
		} else {
			List<String> logins = (List) request.getAttribute("logins");
			if (logins == null) {
				response.sendRedirect("success.jsp");
			} else {
				out.println("<form action=\"InsertLoginToBase.admin\" method=\"post\">");
				out.println(
						"<p><strong>Логин :</strong> <input maxlength=\"25\" size=\"40\" name=\"loginToInsert\">");
				out.println("</p><p>");
				out.println(
						"<strong>Пароль:</strong> <input type=\"password\" maxlength=\"25\"	size=\"40\" name=\"password1\">");
				out.println("</p><p>");
				out.println(
						"<strong>Пароль:</strong> <input type=\"password\" maxlength=\"25\" size=\"40\" name=\"password2\"></p>");
				out.println("<p><input type=\"submit\" value=\"Добавить\"></p></form>");
				out.println("<br><form action=\"Main.user\" method=\"post\">");
				out.println("<p><input type=\"submit\" value=\"На главную\"></p></form>");
			}
		}
	%>
</body>
</html>