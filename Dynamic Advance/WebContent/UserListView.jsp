
<%@page import="in.co.rays.Bean.UserBean"%>
<%@page import="com.sun.source.tree.WhileLoopTree"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<%@ include file="Header.jsp"%>
		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
		%>
		<table>
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>Address</th>
				<th>Edit</th>

			</tr>


			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>

			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstname()%></td>
				<td><%=bean.getLastname()%></td>
				<td><%=bean.getLoginid()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getAdress()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>


		</table>
	</form>
</body>
</html>