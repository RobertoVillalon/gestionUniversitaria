<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estudiantes por Curso</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
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
        <div class="container my-4">
            <h2 class="text-center">Estudiantes del Curso: ${course.name}</h2>

            <!-- Tabla de estudiantes -->
            <form action="course" method="post">
                <input type="hidden" name="action" value="deleteAllStudent" />
                <input type="hidden" name="studentId" value="${student.id}"/>
                <input type="hidden" name="courseId" value="${course.id}"/>
                <button type="submit" class="btn btn-primary">Borrar Todos los estudiantes</button>
            </form>
            <table class="table table-striped table-bordered mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th>Nombre</th>
                        <th>Primer Apellido</th>
                        <th>Segundo Apellido</th>
                        <th>RUN</th>
                        <th>Edad</th>
                        <th>Email</th>
                        <th>Carrera</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.name}</td>
                            <td>${student.firstLastName}</td>
                            <td>${student.secondLastName}</td>
                            <td>${student.run}</td>
                            <td>${student.age}</td>
                            <td>${student.email}</td>
                            <td>${student.degree.name}</td>
                            <td>
                                <form action="course" method="post">
                                    <input type="hidden" name="action" value="deleteStudent" />
                                    <input type="hidden" name="studentId" value="${student.id}"/>
                                    <input type="hidden" name="courseId" value="${course.id}"/>
                                    <button type="submit" class="btn btn-primary">Borrar del curso</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Mensaje si no hay estudiantes en el curso -->
            <c:if test="${empty students}">
                <div class="alert alert-info text-center" role="alert">
                    No hay estudiantes inscritos en este curso.
                </div>
            </c:if>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
