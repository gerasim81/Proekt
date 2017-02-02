<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type"
	content="text/html; charset=UTF-8">
<title>Написать</title>
</head>

<body>
	<%	
				List<String> logins = (List)request.getAttribute("logins");
				if (logins == null){
					response.sendRedirect("success.jsp");
				}
				else{
					out.println("<form action=\"SendMessage.user\" method=\"post\" accept-charset=\"UTF-8\">");
					out.println("Выберите пользователя, которому написать сообщение:");
					out.println("<br><p>");
					out.println("<select size=\"1\" name=\"loginToSend\">");
										
					for (String s : logins){
						out.print("<option value=\"" + s + "\"" + ">" + s + "</option>");
					}
					out.println("</select> <br>");
					out.println("</p><br>");
					out.println("<p><textarea name=\"sendedMessage\" cols=\"50\" rows=\"10\" ></textarea></p>");
					out.println("<br><p>");
					out.println("<input type=\"submit\" value=\"Послать\"></p></form>");
					
					out.println("<form action=\"Main.user\" method=\"post\">");
					out.println("<p><input type=\"submit\" value=\"На главную\"></p></form>");
				}
			
			%>
</body>
</html>