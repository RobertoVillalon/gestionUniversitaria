<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estudiantes - Sistema de Gestión</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <style>
        /* Estilo para ajustar el contenido al sidebar y al navbar */
        body {
            padding-top: 70px; /* Ajusta el espacio para que no se solape con el navbar */
        }

      
        .container {
            margin-left: 220px; /* Deja espacio para el sidebar */
            padding-top: 20px;
        }

        
        .content {
            margin-left: 220px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-custom">
        <div class="container">
            <a class="navbar-brand" href="#">Gestión Estudiantil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <!-- Menú de navegación -->
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

                <!-- Barra de búsqueda -->
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
    <div class="container">
        <h1 class="my-4">Listado de Cursos</h1>

        <div class="d-inline-flex">
            <div class="d-flex justify-content-between m-2">
                <a href="course?action=create" class="btn btn-success">Agregar Curso</a>
            </div>
            <div class="d-flex justify-content-between m-2">
                <a href="course?action=assign" class="btn btn-success">Asignacion de Estudiantes</a>
            </div>
        </div>

       
        
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Course Name</th>
                    <th>Degree</th>
                    <th>Professor</th>
                    <th>Alumnos</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.name}</td>
                        <td>${course.degree.name}</td>
                        <td>${course.professor.name} ${course.professor.firstLastName}</td>
                        <td>
                            <form action="course" method="get">
                                <input type="hidden" name="action" value="students" />
                                <input type="hidden" name="courseId" value="${course.id}"/>
                                <button type="submit" class="btn btn-primary">Estudiantes</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <!-- Paginación se agregará aquí dinámicamente -->
            </ul>
        </nav>
    </div>

    <script src="js/students.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
