
<%@page import="in.co.rays.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean bean = (UserBean) request.getAttribute("Bean");
	%>
	<form action="UserCtl.do" method="post">

		<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
		<table>
			<tr>
				<th>first Name :</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstname()%>"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="lastName"
					value="<%=bean.getLastname()%>"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginid()%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"
					value="<%=bean.getAdress()%>"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=bean.getAdress()%>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="Operation" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>