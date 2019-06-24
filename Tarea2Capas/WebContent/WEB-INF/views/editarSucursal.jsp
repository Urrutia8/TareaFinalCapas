<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Editar Sucursal - Restaurante Rustico</title>
</head>
<body>
	<h1 style="text-align: center;">Editar Sucursal: ${sucursal.nombre}</h1>
	<br>	
	<div class="form-group" style="margin: auto; padding: 5px; width: 30%; border: solid;border-width: 1px; border-radius: 5px; border-color: gray;">
		<form:form action="${pageContext.request.contextPath}/actualizarSucursal" method="post" modelAttribute="sucursal">
			<input type="hidden" name="codigo" path="codigo" value="${sucursal.codigo}">
			
			<label  for="nombre">Nombre de sucursal:</label>
			<form:errors path="nombre" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="nombre" path="nombre" value="${sucursal.nombre}" placeholder="Rustico con clase"/>
			<br>
			<label  for="nomGerente">Nombre de gerente:</label>
			<form:errors path="nomGerente" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="nomGerente" path="nomGerente" value="${sucursal.nomGerente}" placeholder="Monica Arana"/>
			<br>
			<label  for="ubicacion">Ubicaci&oacute;n:</label>
			<form:errors path="ubicacion" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="ubicacion" path="ubicacion" value="${sucursal.ubicacion}" placeholder="Ave. Joplins, 3ra calle #595"/>
			<br>
			<label  for="nMesa">Numero de mesas en el local:</label>
			<form:errors path="nMesa" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="nMesa" path="nMesa" value="${sucursal.nMesa}" placeholder="15"/>
			<br>
			<label  for="horarioInicio">Hora de inicio de actividades:</label>
			<form:errors path="horarioInicio" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="horarioInicio" path="horarioInicio" value="${sucursal.horarioInicio}" placeholder="6:30"/>
			<br>
			<label for="horarioFin">Hora de fin de actividades:</label>
			<form:errors path="horarioFin" cssStyle="color: #ff0000;" />
			<input class="form-control" type="text" name="horarioFin" path="horarioFin" value="${sucursal.horarioFin}" placeholder="21:00"/>
			<br>
			<input class="btn btn-success btn-block" type="submit" value="Guardar cambios"/>		
		</form:form>
	</div>
	
	<c:if test="${sucursal.codigo != null}">
		<br><br>
		<div class="container">
			<h2 style="text-align: center;">Empleados de ${sucursal.nombre}</h2>
			
			<button onClick="location.href='${pageContext.request.contextPath}/agregarEmpleado?id_sucursal=${sucursal.codigo}'"
			class="btn btn-success">Agregar Empleado</button>
			<br><br>
			<table class="table table-striped">
					<thead>
						<tr>
							<td scope="col" style="text-align: center;">Nombre Completo</td>
							<td scope="col" style="text-align: center;">Edad</td>
							<td scope="col" style="text-align: center;">G&eacute;nero</td>
							<td scope="col" style="text-align: center;">Estado</td>
							<td scope="col" style="text-align: center;">Acciones</td>
						</tr>
					</thead>
				<c:forEach items="${empleados}" var="empleado">
					<tr>
						<td style="text-align: center;">${empleado.nombre}</td>
						<td style="text-align: center;">${empleado.edad}</td>
						<td style="text-align: center;">${empleado.genero}</td>
						<td style="text-align: center;">${empleado.estado}</td>
						<td style="text-align: center;">
							<button onclick="location.href='${pageContext.request.contextPath}/editarEmpleado?codigo=${empleado.codigo}'"
							class="btn btn-primary">Ver Perfil</button>
							
							<button onclick="location.href='${pageContext.request.contextPath}/borrarEmpleado?codigo=${empleado.codigo}&id_sucursal=${sucursal.codigo}'"
							class="btn btn-danger">Eliminar</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>