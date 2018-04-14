<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%>
<br><br><br><br>
	
		<form action="ProjectServlet?action=sendRequest&projectId=<%= request.getParameter("projectId") %>" method="post">
		<table width="35%" align="center" border="0" cellspacing="1"
		cellpadding="0" BORDERCOLOR="lightgray">
		<tr>
		<td>
			Comments: <textarea rows="5" cols="50" name="comments"></textarea>
			</td>
		</tr>
		<tr>
		<td align="center">
		 <br><input type="submit" value="Send"/>
		 </td>
		</tr>
		</table>
			</form>
		

</body>
</html>