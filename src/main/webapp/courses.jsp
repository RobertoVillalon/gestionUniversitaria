<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Courses</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5 mb-4">Create New Course</h2>

        <!-- Form to Create a New Course -->
        <form action="course" method="post">
            <input type="hidden" name="action" value="create" />

            <div class="form-group">
                <label for="name">Course Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter course name" required>
            </div>

            <!-- Select Degree -->
            <div class="form-group">
                <label for="degree">Select Degree:</label>
                <select name="degreeId" id="degree" class="form-control" required>
                    <c:forEach var="degree" items="${degrees}">
                        <option value="${degree.id}">${degree.name}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Select Professor -->
            <div class="form-group">
                <label for="professor">Select Professor:</label>
                <select name="professorId" id="professor" class="form-control" required>
                    <c:forEach var="professor" items="${professors}">
                        <option value="${professor.id}">${professor.name} ${professor.firstLastName}</option>
                    </c:forEach>
                </select>
            </div>


            <button type="submit" class="btn btn-primary">Create Course</button>
        </form>

        <h2 class="mt-5 mb-4">List of Courses</h2>

        <!-- Table to List Courses -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Course Name</th>
                    <th>Degree</th>
                    <th>Professor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.name}</td>
                        <td>${course.degree.name}</td>
                        <td>${course.professor.name} ${course.professor.firstLastName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <form action="course" method="get">
            <input type="hidden" name="action" value="assign" />
            <button class="btn btn-primary" type="submit">ir a Asignar Estudiante</button>
        </form>
    </div>

    <!-- Optional JavaScript and Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
