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
	
	<form action="ProjectServlet?action=addProject" method="post">
	<table width="25%" align="center">
		<tr bgcolor="lightgreen">
			<td colspan="2">
				<b> Add Project </b>
			</td>
		</tr>
		<tr><td colspan="2"> &nbsp;</td></tr>
		<tr>
			<td>
				Name :
			</td>
			<td>
				<input type="text" name="name"/>
 			</td>
		</tr>
		<tr>
			<td>
				Ethnicity :
			</td>
			<td>
				<input type="text" name="ethnicity"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Minimum Height :
			</td>
			<td>
				<input type="text" name="minHeight"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Maximum Height :
			</td>
			<td>
				<input type="text" name="maxHeight"/> 
 			</td>
		</tr>
		<tr>
			<td>
				Minimum Age :
			</td>
			<td>
				<input type="text" name="minAge"/>
 			</td>
		</tr>
		<tr>
			<td>
				Maximum Age :
			</td>
			<td>
				<input type="text" name="maxAge"/>
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