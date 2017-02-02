<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Главная</title>
</head>
<body>

	<%
		out.println("Вы авторизованы как");
		out.println(session.getAttribute("login"));
		out.println("<br>");
		out.println("<br>");
		out.println("Номер сессии   " + session.getId());
		//out.println(request.getSession().getId());
		out.println("<br>");
		out.println("<br>");
		out.println("Если вы хотите зайти под другим логином нажмите Logout.");
		out.println("<br>");
		out.println("<br>");
		out.println("<form method=\"post\" action=Logout.user>");
		out.println("<button type=\"SUBMIT\">Logout</button>");
		out.println("</form>");
		out.println("<br>");
		out.println("<form method=\"post\" action=inMessageSelect.user>");
		out.println("<button type=\"SUBMIT\">Входящие</button>");
		out.println("</form>");
		out.println("<br>");

		out.println("<form method=\"post\" action=outMessageSelect.user>");
		out.println("<button type=\"SUBMIT\">Исходящие</button>");
		out.println("</form>");
		out.println("<br>");

		out.println("<form method=\"post\" action=writeLetter.user>");
		out.println("<button type=\"SUBMIT\">Написать</button>");
		out.println("</form>");
		out.println("<br>");

		if (((String) session.getAttribute("admin")) != null) {
			if (((String) session.getAttribute("admin")).equals("true")) {

				
				
				out.println("<form method=\"post\" action=AddLogin.admin>");
				out.print("<p><img src=\"add.jpg\" width=\"50\" height=\"50\" alt=\"Добавить\">");
				out.println("<button type=\"SUBMIT\">Добавить логин</button></p>");
				out.println("</form>");
				out.println("<br>");

				
				out.println("<form method=\"post\" action=DeleteLogin.admin>");
				out.print("<p><img src=\"del.jpg\" width=\"50\" height=\"50\" alt=\"Удалить\">");
				out.println("<button type=\"SUBMIT\">Удалить логин</button></p>");
				out.println("</form>");
				out.println("<br>");
}
		}
	%>
</body>
</html>