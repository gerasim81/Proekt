<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Удалить логин</title>
</head>
<body>
	<%
		if (((String) session.getAttribute("admin")) == null) {
			response.sendRedirect("success.jsp");
		} else {
			List<String> logins = (List) request.getAttribute("loginsToSelect");
			if (logins == null) {
				response.sendRedirect("success.jsp");
			} else {

				out.println("<form action=\"DeleteLoginFromBase.admin\" method=\"post\" accept-charset=\"UTF-8\">");
				out.println("Выберите пользователя, которого удалить:");
				out.println("<br><p>");
				out.println("<select size=\"1\" name=\"loginToDelete\">");

				for (String s : logins) {
					if (s.equals("admin")) {
						continue;
					}
					out.print("<option value=\"" + s + "\"" + ">" + s + "</option>");
				}
				out.println("</select></p><br>");
				out.println("<input type=\"submit\" value=\"Удалить\"></p></form>");
				out.println("<br><form action=\"Main.user\" method=\"post\">");
				out.println("<p><input type=\"submit\" value=\"На главную\"></p></form>");

			}
		}
	%>
</body>
</html>