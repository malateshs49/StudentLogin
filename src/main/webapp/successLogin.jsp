<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Success</title>

</head>

<body>

	<font color="green"><h2>Hello</h2></font>

	<h3>${msg}</h3>
	You have successfully logged in.

	<font color="green"><h3>Welcome to Spring Boot World !</h3></font>

</body>
<form action="/backLogin" method="get">
	<table>
		<tr>
			<td style="text-align: center"><input type="submit" name="back"
				value="Back" /></td>
		</tr>
	</table>
</form>


