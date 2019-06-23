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
	<link href="resources/css/branchesEditStyle.css" rel="stylesheet">
	<script src="resources/js/branchesEdit.js" type="text/javascript"></script>
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
			<div class="col-md-3 header-message">
				<span>${headerMessage}</span>	
			</div>
		</div>
	</nav>

	<div class="row h-100">
       <div class="col-md-5 padding-top leftContainer">
       	<div id="user-form" class="fill-full-width border-radius-padding">
	       	<form:form action="${pageContext.request.contextPath}/edit-branch" method="POST" modelAttribute="branch">		
				 <div class="form-group">
				 	<label for="articleNameInput">Nombre</label>
				 	<form:input type="text" class="form-control"  path="name" name="usernameInput" />
				 	<form:errors path="name" cssStyle="color: #E81505"/>			
				 	<form:hidden path="id"/>		 						 	
				 </div>
				  <div class="form-group">
				 	<label for="articleNameInput">Dirección</label>
				 	<form:input type="text" class="form-control"  path="address" name="usernameInput" />
				 	<form:errors path="address" cssStyle="color: #E81505"/>					 						 	
				 </div>
				 <div class="form-group">
				 	<label for="schedulesInput">Horarios</label>				 	
				 	<form:input type="text" class="form-control"  path="schedules" name="schedulesInput" />
				 	<form:errors path="schedules" cssStyle="color: #E81505"/>				 						 	
				 </div>				 
				 <div class="row">
				 	
				 	<div class="col-md-6 form-container">			 		
					 	<div class="form-group">
					 		<label for="articleNameInput">N° Mesas</label>
					 		<form:input type="text" class="form-control"  path="numberOfTables" name="usernameInput" />
					 		<form:errors path="numberOfTables" cssStyle="color: #E81505"/>					 						 	
						</div>				 								 					 						 	
				 	</div>
				 	<div class="col-md-6 form-container">			 		
	 					<div class="form-group">
					 		<label for="articleNameInput">Gerente</label>
					 		<form:input type="text" class="form-control"  path="managerName" name="usernameInput" />
					 		<form:errors path="managerName" cssStyle="color: #E81505"/>					 						 	
						</div>	 	
				 	</div>
				 </div>	
				 <div class="row">
				 	
				 	<div class="col-sm-12 col-md-6 form-container">			 		
				 		<button class="btn btn-primary" type="submit" type="reset"><i class="fas fa-arrow-alt-circle-up submitIcon"></i>Editar</button>					 								 					 						 	
				 	</div>
				 	<div class="col-sm-12 col-md-6 form-container">			 		
				 		<button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/delete?id=${branch.getId()}'" type="reset"><i class="far fa-trash-alt submitIcon"></i>Borrar</button>					 								 					 						 	
				 	</div>
				 </div>					 					
			</form:form>
       	</div>
       </div>
       <div class="col-md-7 padding-top rightContainer">
       	<h1>Empleados</h1>
      	<div class="table-container">
       		<table class="table table-bordered">
	       		<thead>
	       			<tr>
	       				<th>Nombre</th>
	       				<th>Edad</th>
	       				<th>Género</th> 
	       				<th>Estado</th>       				
	       				<th class="lastColumn"></th>
	       			</tr>
	       		</thead>
	       	
	       	<c:forEach items="${branch.getEmployees()}" var="employee"> 
				<tr>
					<td><c:out value = "${employee.getName()}"/></td>	
					<td><c:out value = "${employee.getAge()}"/></td>	
					<td><c:out value = "${employee.getGenre()}"/></td>	
					<td><c:out value = "${employee.getDelegateStatus()}"/></td>				
					<td class="last-column"><Button class="btn btn-primary" style="margin-right: 8px;" onclick="location.href='${pageContext.request.contextPath}/edit-new-employee?employee_id=${employee.getId()}&branch_id=${branch.getId()}'"><i class="fas fa-edit"></i></Button> </td>
				</tr>
			</c:forEach>	
			</table>
		</div>
		<button class="btn btn-success create-new-employee" onclick="location.href='${pageContext.request.contextPath}/create-new-employee?branch_id=${branch.getId()}'">Contratar empleado</button>
		<button class="btn btn-primary return-to-branches" onclick="location.href='${pageContext.request.contextPath}/branches'">Regresar</button>
       </div>
	</div>
</body>
</html>