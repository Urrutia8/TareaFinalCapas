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
	<link href="resources/css/loginStyle.css" rel="stylesheet">
	<script src="resources/js/login.js" type="text/javascript" ></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	
</head>
<body>
	<div class="row h-100">
        <div class="col-sm-12 col-md-6 leftSection">
        	<h1 class="rusticoNameLabel">Rustico</h1>
        	<i class="fas fa-leaf rusticoLogo"></i>
        	<br>
			<h1 id="rustico-label" class="rusticoLabel">Tu lugar preferido para comer </h1>
        </div>

        <div class="col-sm-12 col-md-6 rightSection">
			<div id="user-form" class="fill-full-width border-radius-padding">
				<form:form action="${pageContext.request.contextPath}/login" method="POST" modelAttribute="user">
				
					 <div class="form-group">
					 	<label for="articleNameInput">Usuario</label>
					 	<form:input type="text" class="form-control"  path="username" name="usernameInput" />
					 	<form:errors path="username" cssStyle="color: #E81505"/>					 						 	
					 </div>
					  <div class="form-group">
					 	<label for="passwordInput">Contraseña</label>
					 	<form:password showPassword="true"   class="form-control" path="password" name="passwordInput" />					 	
					 	<form:errors path="password" cssStyle="color: #E81505"/>					 						 	
					 </div>
					 <div class="row">
					 	
					 	<div class="col-md-12 form-container">
					 		
					 		<button class="btn btn-primary" type="submit" type="reset"><i class="fas fa-arrow-alt-circle-up submitIcon"></i>Iniciar sesión</button>					 								 		
					 						 		
					 	</div>
					 </div>					 					
				</form:form>
			</div>
        </div>

	</div>
</body>
</html>