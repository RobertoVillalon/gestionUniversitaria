<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Professors</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5 mb-4">Create New Professor</h2>

        <!-- Form to Create a New Professor -->
        <form action="professor" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
            </div>
            <div class="form-group">
                <label for="firstlastname">First Last Name:</label>
                <input type="text" class="form-control" id="firstlastname" name="firstlastname" placeholder="Enter first last name" required>
            </div>
            <div class="form-group">
                <label for="secondlastname">Second Last Name:</label>
                <input type="text" class="form-control" id="secondlastname" name="secondlastname" placeholder="Enter second last name" required>
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
                <label for="run">RUN:</label>
                <input type="text" class="form-control" id="run" name="run" placeholder="Enter RUN" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Professor</button>
        </form>

        <h2 class="mt-5 mb-4">List of Professors</h2>

        <!-- Table to List Professors -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>First Last Name</th>
                    <th>Second Last Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>RUN</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="professor" items="${professors}">
                    <tr>
                        <td>${professor.name}</td>
                        <td>${professor.firstLastName}</td>
                        <td>${professor.secondLastName}</td>
                        <td>${professor.age}</td>
                        <td>${professor.email}</td>
                        <td>${professor.run}</td>
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
