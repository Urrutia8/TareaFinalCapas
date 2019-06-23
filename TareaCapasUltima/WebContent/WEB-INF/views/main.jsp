<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Log In - Restaurante Rustico</title>
</head>
<body>
	<h1 style="text-align: center;">Restaurante Rustico</h1>
	<br>
	<div class="container" style="margin: auto; padding: 5px; height: 50%; width: 20%; border: solid;border-width: 1px; border-radius: 5px; border-color: gray;">
		<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="usuario">
			<label for="usuario">Usuario:</label>
			<form:errors path="usuario" cssStyle="color: #ff0000;" />
			<form:input class="form-control" type="text" name="usuario" path="usuario" placeholder="jbalvin"/>
			<br>
			<label for="password">Contrase&ntilde;a:</label>
			<form:errors path="clave" cssStyle="color: #ff0000;" />
			<form:input class="form-control" type="password" name="clave" path="clave"/>
			<br>
			<input class="btn btn-success btn-block" type="submit" value="Ingresar">
		</form:form>
	</div>	
	
</body>
</html>