<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<body>
	<%
		String userId = (String) session.getAttribute("userId");
		String userRole = (String) session.getAttribute("userRole");
	%>
	<div width="20%" height="80px">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="2" height="1"><img src="images/logo.jpg"
					width="100px" height="100px"></td>
				<td>
					<table border="0" width="100%">
						<tr>
							<td width="55%" align="right">
								<h2>Subject Management System</h2>
							</td>
							<td align="right" width="45%">
								<%
									if (userId == null) {
								%> <a href="login.jsp">Login</a><br>
								 <a href="signup.jsp"
								class="right">Signup</a><br> <a href="index.jsp">Home</a> <%
 								} else {
								%> Welcome&nbsp;<%=userId%><br> <a
								href="LoginServlet?action=logout" class="right">Logout</a><br>
								<%
									}
								%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<!-- <div width="100%" height="10px" style="background-color: lightgrey">-->
	<ul>

		<%
			System.out.println(userRole + "  userRole !");
			if (userRole == null) {
		%>
		<li class="dropdown"><a href="aboutus.jsp" class="dropbtn">About
				Us</a></li>
		<li class="dropdown"><a href="contactus.jsp" class="dropbtn">Contact
				Us</a></li>
		<%
			} else if (userRole.equals("admin")) {
		%>
		<li class="dropdown"><a class="dropbtn">Recruiters</a>
			<div class="dropdown-content">
				<a href="RecruiterServlet?action=listRecruiters">Recruiters</a> 
			</div></li>

		<li class="dropdown"><a href="aboutus.jsp" class="dropbtn">About
				Us</a></li>
		<li class="dropdown"><a href="contactus.jsp" class="dropbtn">Contact
				Us</a></li>
		<%
			} else if(userRole.equals("subject")){
		%>
			<li class="dropdown"><a class="dropbtn">Projects</a>
				<div class="dropdown-content">
					<a href="ProjectServlet?action=listProjects">Projects</a>
					 <a href="ProjectServlet?action=listRequests">My Requests</a>
				</div>
			</li>
			<li class="dropdown">
				<a href="aboutus.jsp" class="dropbtn">About Us</a>
			</li>
			<li class="dropdown">
				<a href="contactus.jsp" class="dropbtn">Contact Us</a>
			</li>
		<%
			}else{
			%>
			<li class="dropdown"><a class="dropbtn">Projects</a>
			<div class="dropdown-content">
				<a href="ProjectServlet?action=listProjects">Projects</a> 
			</div>
			</li>
			<li class="dropdown"><a href="aboutus.
			jsp" class="dropbtn">About
					Us</a></li>
			<li class="dropdown"><a href="contactus.jsp" class="dropbtn">Contact
					Us</a></li>
				
			<%}
		%>
	</ul>


</body>
</html>