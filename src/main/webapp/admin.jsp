<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Solicitudes</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Solicitudes</h2>

    <table class="table table-bordered table-hover table-striped">
        <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Libro</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty solicitudes}">
                    <c:forEach var="s" items="${solicitudes}">
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.nombre}</td>
                            <td>${s.correo}</td>
                            <td>${s.id_libro}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4" class="text-center text-muted">
                            No hay solicitudes registradas
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS (opcional si usas componentes interactivos) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>