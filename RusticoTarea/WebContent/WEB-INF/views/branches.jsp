<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link href="resources/css/branchesStyle.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	
</head>
<body>
	<nav>
		<div class="row">
			<div class="col-md-1 form-container">
			    <i class="fas fa-leaf"></i>
			</div>
			<div class="col-md-8 library-name-section">
				<span>Rustico</span>					
			</div>
			<div class="col-md-3 library-name-section">				
				<span>Sucursales</span>
			</div>
		</div>
	</nav>

	<div class="row h-100">
       <div class="col-md-1"></div>
       <div class="col-md-10">
       	<table class="table table-bordered">
       		<thead>
       			<tr>
       				<th>Nombre</th>
       				<th>Dirección</th>
       				<th >Horarios</th>       				
       				<th style="width: 100px;">N° Mesas</th>
       				<th style="width: 230px;">Gerente</th>
       				<th style="width: 55px;"></th>
       			</tr>
       		</thead>
       	
       	<c:forEach items="${branches}" var="branch"> 
			<tr>
				<td><c:out value = "${branch.getName()}"/></td>
				<td><c:out value = "${branch.getAddress()}"/></td>
				<td><c:out value = "${branch.getSchedules()}"/></td>
				<td><c:out value = "${branch.getNumberOfTables()}"/></td>
				<td><c:out value = "${branch.getManagerName()}"/></td>			
				<td class="last-column"><Button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/edit?id=${branch.getId()}'"><i class="fas fa-edit"></i></Button> </td>
			</tr>
		</c:forEach>	
		</table>
       </div>
       <div class="col-md-1">
       		<button class="btn btn-success create-new-branch" onclick="location.href='${pageContext.request.contextPath}/create-new-branch'">Crear nuevo</button>
       </div>
	</div>
</body>
</html>