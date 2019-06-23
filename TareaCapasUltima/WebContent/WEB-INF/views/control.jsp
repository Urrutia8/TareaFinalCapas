<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Centro de control - Restaurante Rustico</title>
</head>
<body>
	<h1 style="text-align: center;">Centro de control de sucursales</h1>
	<br>
	<div class="container" style="margin: auto;">
		<form action="${pageContext.request.contextPath}/agregarSucursal">
		<input class="btn btn-success" style="margin: auto;" type="submit" value="Agregar Sucursal"/>
	</form>
	</div>
	<br>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<td scope="col" style="text-align: center;">Nombre de Sucursal</td>
					<td scope="col" style="text-align: center;">Direcci&oacute;n</td>
					<td scope="col" style="text-align: center;">Horario de apertura</td>
					<td scope="col" style="text-align: center;">Horario de cierre</td>
					<td scope="col" style="text-align: center;">Acciones</td>
				</tr>
			</thead>
			<c:forEach items="${sucursales}" var="sucursales">
				<tr>
					<td style="text-align: center;">${sucursales.nombre}</td>
					<td style="text-align: center;">${sucursales.ubicacion}</td>
					<td style="text-align: center;">${sucursales.horarioInicio}</td>
					<td style="text-align: center;">${sucursales.horarioFin}</td>
					<td style="text-align: center;">
						<button onclick="location.href='${pageContext.request.contextPath}/editarSucursal?codigo=${sucursales.codigo}'"
						class="btn btn-primary">Ver Perfil</button>
						<button onclick="location.href='${pageContext.request.contextPath}/borrarSucursal?codigo=${sucursales.codigo}'"
						class="btn btn-danger">Eliminar</button>
						<button onClick="location.href='${pageContext.request.contextPath}/agregarEmpleado?id_sucursal=${sucursales.codigo}'"
						class="btn btn-success">Agregar Empleado</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>