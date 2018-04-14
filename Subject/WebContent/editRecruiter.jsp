<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.subject.entity.Recruiter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<br><br><br><br>
	<%
	Recruiter r = (Recruiter) request.getAttribute("recruiter");
	%>
	<form action="RecruiterServlet?action=updateRecruiter&recruiterId=<%= r.getId() %>" method="post">
	<table width="25%" align="center">
		<tr bgcolor="lightgreen">
			<td colspan="2">
				<b> Edit Recruiter </b>
			</td>
		</tr>
		<tr><td colspan="2"> &nbsp;</td></tr>
		<tr>
			<td>
				Name :
			</td>
			<td>
				<input type="text" name="name" value="<%= r.getRecruiterName() %>"/>
 			</td>
		</tr>
		<tr>
			<td>
				Phone number:
			</td>
			<td>
				<input type="text" name="phoneNumber" value="<%= r.getPhoneNumber() %>"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Email :
			</td>
			<td>
				<input type="text" name="email" value="<%= r.getEmail() %>"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Address :
			</td>
			<td>
				<textarea name="address" rows="4" cols="30"><%= r.getAddress() %></textarea> 
 			</td>
		</tr>
		<tr>
			<td>
				username :
			</td>
			<td>
				<input type="text" name="username" value="<%= r.getUsername() %>"/>
 			</td>
		</tr>
		<tr>
			<td>
				password :
			</td>
			<td>
				<input type="password" name="password" value="<%= r.getPassword() %>"/>
 			</td>
		</tr>
		<tr><td colspan="2"> &nbsp;</td></tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>