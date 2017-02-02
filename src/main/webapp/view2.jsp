<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Входящие</title>
</head>

<body>
	<%
		List<String> inMessages = (List) request.getAttribute("inMessages");
		if (inMessages == null) {
			response.sendRedirect("success.jsp");
		} else {
			out.println("<form action=\"inMessageShow.user\" method=\"post\">");
			out.println("Выберите сообщение:<br><p><select size=\"1\" name=\"inMessages\">");

			String[] temp = new String[9];
			String tek = "", name = "", id = "";

			for (int i = 0; i < inMessages.size(); i++) {
				tek = inMessages.get(i);
				temp = tek.split(" ");
				id = temp[8];
				name = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3] + " " + temp[4] + " " + temp[5] + " "
						+ temp[6] + " " + temp[7];

				out.print("<option value=\"" + id + "\"" + ">" + name + "</option>");
			}

			out.println("</select> <br></p>Показать сообщение:<p>");
			out.println("<input type=\"submit\" value=\"Показать\">");
			out.println("</p></form>");
			out.println("<form action=\"Main.user\" method=\"post\">");
			out.println("<p><input type=\"submit\" value=\"На главную\"></p></form>");
		}
	%>
</body>
</html>