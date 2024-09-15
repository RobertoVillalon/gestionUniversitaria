<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Gestión - Actualizar Curso</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container">
        <a class="navbar-brand" href="#">Gestion Estudiantil</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="students.html">Estudiantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="courses.html">Cursos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="panel.html">Reportes</a>
                </li>
            </ul>

            <div class="navbar-search">
                <input type="text" class="form-control" placeholder="Buscar...">
            </div>
        </div>
    </div>
</nav>

<!-- Sidebar -->
    <div class="sidebar" id="sidebar">
        <a href="student?action=view">Estudiantes</a>
        <a href="course?action=view">Curso</a>
    </div>

<!-- Contenido Principal -->
<div class="content">
    <div class="container form-container my-4">
        <h2 class="text-center">Actualizar Curso</h2>

        <!-- Mensaje de éxito -->
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success" role="alert">
                ${successMessage}
            </div>
        </c:if>

        <!-- Formulario para actualizar estudiante -->
             <form action="course" method="post">
                <input type="hidden" name="action" value="create" />

                <div class="form-group">
                    <label for="name">Nombre del Curso:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter course name" required>
                </div>

                <!-- Select Degree -->
                <div class="form-group">
                    <label for="degree">Seleccionar Carrera:</label>
                    <select name="degreeId" id="degree" class="form-control" required>
                        <c:forEach var="degree" items="${degrees}">
                            <option value="${degree.id}">${degree.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Select Professor -->
                <div class="form-group">
                    <label for="professor">Seleccionar Profesor:</label>
                    <select name="professorId" id="professor" class="form-control" required>
                        <c:forEach var="professor" items="${professors}">
                            <option value="${professor.id}">${professor.name} ${professor.firstLastName}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <button type="submit" class="btn btn-primary">Create Course</button>

            </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

        </div>
    </body>
</html>
