<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Solicitud de libro</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2>Solicitud de libro</h2>
		
		<c:if test="${not empty error}">
        	<div class="alert alert-danger" role="alert"><c:out value="${error}" /></div>
    	</c:if>
    	
		<form action="solicitud" method="post">
			<div class="mb-3">
		    	<label>Libro: <c:out value="${libro.nombre}" /></label>
		    	<input type="hidden" name="id_libro" value="<c:out value='${libro.id}' />">
		  	</div>
			<div class="mb-3">
		    	<label for="nombre" class="form-label">Nombre completo</label>
		    	<input type="text" class="form-control" id="nombre" name="nombre" required>
		  	</div>
		  	<div class="mb-3">
		    	<label for=correo class="form-label">Correo</label>
		    	<input type="text" class="form-control" id="correo" name="correo" required>
		  	</div>
		  	<button type="submit" class="btn btn-primary">Solicitar</button> 
		  	<a href="catalogo" class="btn btn-secondary">Volver</a>
		</form>
	</div>
	
	<!-- Bootstrap JS (opcional si necesitas componentes interactivos) -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>