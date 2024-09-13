<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Students</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5 mb-4">Create New Student</h2>

        <!-- Form to Create a New Student -->
        <form action="student" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter student name" required>
            </div>

            <div class="form-group">
                <label for="firstLastName">First Last Name:</label>
                <input type="text" class="form-control" id="firstLastName" name="firstLastName" placeholder="Enter first last name" required>
            </div>

            <div class="form-group">
                <label for="secondLastName">Second Last Name:</label>
                <input type="text" class="form-control" id="secondLastName" name="secondLastName" placeholder="Enter second last name" required>
            </div>

            <div class="form-group">
                <label for="run">RUN:</label>
                <input type="text" class="form-control" id="run" name="run" placeholder="Enter student RUN" required>
            </div>

            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" placeholder="Enter age" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
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
                        <option value="${degree.id}">${degree.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Student</button>
        </form>

        <h2 class="mt-5 mb-4">List of Students</h2>

        <!-- Table to List Students -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>First Last Name</th>
                    <th>Second Last Name</th>
                    <th>RUN</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Degree</th>
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Optional JavaScript and Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
