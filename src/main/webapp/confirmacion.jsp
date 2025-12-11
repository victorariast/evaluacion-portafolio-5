<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Confirmación de Solicitud</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="card shadow-sm mx-auto" style="max-width: 600px;">
            <div class="card-body text-center">
                <h2 class="text-success mb-3">¡Solicitud enviada con éxito!</h2>
                <p class="lead">Gracias por tu solicitud, <strong>${solicitud.nombre}</strong>.</p>
                <p>Hemos registrado tu solicitud para el libro:</p>

                <div class="alert alert-info">
                    <h5 class="mb-1">${libro.nombre}</h5>
                    <p class="mb-0"><em>Autor:</em> ${libro.autor}</p>
                </div>

                <hr>

                <p>Te contactaremos al correo: <strong>${solicitud.correo}</strong></p>

                <div class="mt-4">
                    <a href="catalogo" class="btn btn-primary">
                        Volver al catálogo
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
