<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Gestión - Actualizar Estudiante</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <style>
        /* Asegurar que el contenido esté centrado y alineado */
        .content {
            margin-left: 10px;
            margin-right: 100px;
            padding-top: 50px;
        }

        .form-container {
            max-width: 700px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .form-group .form-control {
            max-width: 99%;
        }

        /* Validaciones del RUN */
        .invalid-feedback {
            display: none;
        }
    </style>
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
                <li class="nav-item active">
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
        <h2 class="text-center">Actualizar Estudiante</h2>

        <!-- Mensaje de éxito -->
        <div class="alert alert-success" id="success-message" role="alert" style="display:none;">
            Estudiante actualizado exitosamente!
        </div>

        <!-- Formulario de actualización de estudiantes -->
        <form action="student" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="studentId" value="${student.id}">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${student.name}" placeholder="Enter student name" required>
            </div>

            <div class="form-group">
                <label for="firstLastName">First Last Name:</label>
                <input type="text" class="form-control" id="firstLastName" name="firstLastName" value="${student.firstLastName}" placeholder="Enter first last name" required>
            </div>

            <div class="form-group">
                <label for="secondLastName">Second Last Name:</label>
                <input type="text" class="form-control" id="secondLastName" name="secondLastName" value="${student.secondLastName}" placeholder="Enter second last name" required>
            </div>

            <div class="form-group">
                <label for="run">RUN:</label>
                <input type="text" class="form-control" id="run" name="run" value="${student.run}" placeholder="Enter student RUN" required>
            </div>

            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" value="${student.age}" placeholder="Enter age" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${student.email}" placeholder="Enter email" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
            </div>

            <!-- Select Degree -->
            <div class="form-group">
                <label for="degree">Select Degree:</label>
                <select name="degree_id" id="degree" class="form-control" required>
                    <c:forEach var="degree" items="${degrees}">
                        <option value="${degree.id}" ${degree.id == student.degree.id ? 'selected' : ''}>${degree.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Update Student</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
