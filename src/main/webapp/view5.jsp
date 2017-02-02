<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Сообщение</title>
</head>

<body>
	<%
		String message = (String) request.getAttribute("outMessage");
		if (message == null) {
			response.sendRedirect("success.jsp");
		} else {

			out.println("Сообщение:<br>	<p align=\"left\">");
			out.println("<textarea readonly name=\"comment\" cols=\"50\" rows=\"10\">");
			out.print(message);
			out.println("</textarea></p><form action=\"Main.user\" method=\"post\">");
			out.println("<p><input type=\"submit\" value=\"На главную\"></p></form>");
		}
	%>
</body>
</html>