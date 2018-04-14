<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List,com.subject.entity.Recruiter"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	function add(){
		document.location.href = "addRecruiter.jsp"
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<br><br><br><br>
	
	<%
		List<Recruiter> recruiters = (List) request.getAttribute("recruiters");
		String searchName = request.getParameter("searchname");
	%>
	
	
	<table width="50%" align="center" border="0" cellspacing="1"
		cellpadding="0" BORDERCOLOR="lightgray">
		<tr>
			<td colspan="4">
				<input type="button" value="Add" onclick="add()"/>
			</td>
			<td colspan="4" align="right">
				<form method="Post"
					action="RecruiterServlet?action=searchRecruiter">
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
				Name
			</th><th>
				Phone number
			</th>
			
			<th>
				Email
			</th>
			<th>
				Address
			</th>
			<th>
				User name
			</th>
			<th>
				Password
			</th>
			<th>
				&nbsp;
			</th>
		</tr>
		<% for(Recruiter r : recruiters){
		 %>
		<tr bgcolor="lightgreen">
			<td>
				<%= r.getId() %>
			</td>
			<td>
				<%= r.getRecruiterName() %>
			</td>
			<td>
				<%= r.getPhoneNumber() %>
			</td>
			<td>
				<%= r.getEmail() %>
			</td>
			<td>
				<%= r.getAddress() %>
			</td>
			<td>
				<%= r.getUsername() %>
			</td>
			<td>
				<%= r.getPassword() %>
			</td>
			<td>
				<a href="RecruiterServlet?action=delete&recruiterId=<%=r.getId()%>">
					<input type="button" value="Delete Recruiter">
				</a>
				&nbsp;&nbsp;&nbsp;
				<a href="RecruiterServlet?action=editRecruiter&recruiterId=<%=r.getId()%>">
					<input type="button" value="Edit Recruiter">
				</a>
			</td>
		</tr>
		<% } 
		%>
		</table>
</body>
</html>