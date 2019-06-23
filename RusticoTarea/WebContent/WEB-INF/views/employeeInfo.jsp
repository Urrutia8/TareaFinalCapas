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
	<script src="resources/js/employeeInfo.js" type="text/javascript"></script>
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
       <div class="col-md-12 padding-top leftContainer">
       	<div id="user-form" class="fill-full-width border-radius-padding">
	       	<form:form action="${pageContext.request.contextPath}/create-employee" method="POST" modelAttribute="employee">		
				 <div class="form-group">
				 	<label for="articleNameInput">Nombre</label>
				 	<form:input type="text" class="form-control"  path="name" name="usernameInput" />
				 	<form:errors path="name" cssStyle="color: #E81505"/>			
				 	<form:hidden path="id"/>	
				 	<input type="hidden" name="branchId" value="${branchId}"/>					 							 	
				 </div>
			      <div class="form-group">
				 	<label for="articleNameInput">Edad</label>
				 	<form:input type="text" class="form-control"  path="age" name="usernameInput" />
				 	<form:errors path="age" cssStyle="color: #E81505"/>		
				 </div>
				 <div class="form-group">
				 	<label for="openingWeekendLabel">Género</label>				 	
				 	<form:select class="form-control" path="genre">
		                <form:option value="Masculino">Masculino</form:option>
		                <form:option value="Femenino">Femenino</form:option>		                
		            </form:select>				 						 	
				 </div>
				 <div class="form-group">
				 <div class="form-check-inline">
					  <label class="form-check-label">
					    <form:radiobutton checked="true" path="status" value="true" class="form-check-input"/> Disponible 
					  </label>
					</div>
					<div class="form-check-inline">
					  <label class="form-check-label">
					    <form:radiobutton path="status" value="false" class="form-check-input"/> No disponible
					  </label>
					</div>
								 					 						
				 </div>
								
				 <div class="row">
				 	
				 	<div class="col-sm-12 col-md-6 form-container">			 		
				 		<button class="btn btn-primary" type="submit" type="reset"><i class="fas fa-arrow-alt-circle-up submitIcon"></i>${actionMessage}</button>					 								 					 						 	
				 	</div>
				 	<div class="col-sm-12 col-md-6 form-container">			 	
				 		<c:choose>
         
				         <c:when test = "${employee.getId() != null}">
				            <button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/${pageToRedirect}?employee_id=${employee.getId()}&branch_id=${branchId}'" type="reset"><i class="far fa-trash-alt submitIcon"></i> ${mensajeBoton} </button>
				         </c:when>
				         
				         <c:when test = "${employee.getId() == null}">
				            <button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/${pageToRedirect}?id=${branchId}'" type="reset"><i class="far fa-trash-alt submitIcon"></i> ${mensajeBoton} </button>
				         </c:when>
				      </c:choose>					 								 					 						 	
				 	</div>
				 </div>					 					
			</form:form>
       	</div>
       </div>
	</div>
</body>
</html>