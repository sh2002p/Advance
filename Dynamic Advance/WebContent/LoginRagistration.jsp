<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<center>
		<%@ include file="Header.jsp"%>
		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String)request.getAttribute("uri");
		%>
		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>
		<form action="LoginCtl" method="post">
			<style= color:"red"></style>
			<table>
				<tr>
					<th>LoginId</th>
					<td><input type="text" name="LoginId"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<th></th>
					<td><input style="margin-left: 60px" type="submit"
						value="Login"></td>
				</tr>
				

			</table>
			<td><input type = "hidden" name = "uri" value = <%=uri %>></td>
		</form>
	</center>
</body>
</html>