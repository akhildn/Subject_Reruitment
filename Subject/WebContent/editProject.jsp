<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.subject.entity.Project"%>
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
	Project p = (Project) request.getAttribute("project");
	%>
	<form action="ProjectServlet?action=updateProject&projectId=<%= p.getProjectId() %>" method="post">
	<table width="25%" align="center">
		<tr bgcolor="lightgreen">
			<td colspan="2">
				<b> Edit Project </b>
			</td>
		</tr>
		<tr><td colspan="2"> &nbsp;</td></tr>
		<tr>
			<td>
				Name :
			</td>
			<td>
				<input type="text" name="name" value="<%= p.getProjectName() %>"/>
 			</td>
		</tr>
		<tr>
			<td>
				Ethnicity :
			</td>
			<td>
				<input type="text" name="ethnicity" value="<%= p.getEthnicity() %>"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Minimum Height :
			</td>
			<td>
				<input type="text" name="minHeight" value="<%= p.getMinHeight() %>"/>
 			</td>
		
		</tr>
		<tr>
			<td>
				Maximum Height :
			</td>
			<td>
				<input type="text" name="maxHeight" value="<%= p.getMaxHeight() %>"/> 
 			</td>
		</tr>
		<tr>
			<td>
				Minimum Age :
			</td>
			<td>
				<input type="text" name="minAge" value="<%= p.getMinAge() %>"/>
 			</td>
		</tr>
		<tr>
			<td>
				Maximum Age:
			</td>
			<td>
				<input type="text" name="maxAge" value="<%= p.getMaxAge() %>"/>
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