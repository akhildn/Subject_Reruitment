<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List,com.subject.entity.Recruiter,com.subject.entity.Project"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	function add(){
		document.location.href = "addProject.jsp"
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<br><br><br><br>
	
	<%
		List<Project> projects = (List) request.getAttribute("projects");
		String searchName = request.getParameter("searchname");
	%>
	
	
	<table width="70%" align="center" border="0" cellspacing="1"
		cellpadding="0" BORDERCOLOR="lightgray">
		<tr>
			<td colspan="4">
			<% if(userRole.equals("recruiter")){ %>
				<input type="button" value="Add" onclick="add()"/>
				<% } %>
			</td>
			<td colspan="4" align="right">
				<form method="Post"
					action="ProjectServlet?action=searchProject">
					Search Title:<input type="text" name="searchname"
						value="<%=searchName != null ? searchName : ""%>">&nbsp;<input
						type="submit" value="Search">
				</form>
			</td>	
		</tr>
		<tr bgcolor="lightgrey" align="center">
			<th>
				ID
			</th>
			<th>
				Project Name
			</th>
			<th>
				Ethnicity
			</th>
			
			<th>
				Minimum Height
			</th>
			<th>
				Maximum Height
			</th>
			<th>
				Minimum Age
			</th>
			<th>
				Maximum Age
			</th>
			<th>
				&nbsp;
			</th>
		</tr>
		<% for(Project p : projects){
		 %>
		<tr bgcolor="lightgreen">
			<td>
				<%= p.getProjectId() %>
			</td>
			<td>
				<%= p.getProjectName() %>
			</td>
			<td>
				<%= p.getEthnicity() %>
			</td>
			<td>
				<%= p.getMinHeight() %>
			</td>
			<td>
				<%= p.getMaxHeight() %>
			</td>
			<td>
				<%= p.getMinAge() %>
			</td>
			<td>
				<%= p.getMaxAge() %>
			</td>
			<td>
			<% if(userRole.equals("recruiter")){ %>
				<a href="ProjectServlet?action=delete&projectId=<%=p.getProjectId()%>">
					<input type="button" value="Delete Recruiter">
				</a>
				&nbsp;&nbsp;&nbsp;
				<a href="ProjectServlet?action=editProject&projectId=<%=p.getProjectId()%>">
					<input type="button" value="Edit Recruiter">
				</a>
			<% }else{%>
				<a href="subjectComments.jsp?projectId=<%=p.getProjectId()%>">
					<input type="button" value="Send Request">
				</a>
			<%} %>
			</td>
		</tr>
		<% } 
		%>
		</table>
</body>
</html>