<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<form action="/login" method="post">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td style="text-align: center"><input type="submit"
						name="login" value="Login" /></td>
				</tr>
			</table>
		</form>
		
		<form action="/registration" method="get">
			<table>
				<tr>
					<td style="text-align: center"><input type="submit"
						name="register" value="Register" style="margin-left: 60%" /></td>
				</tr>
			</table>
		</form>


	</div>
</body>
</html>