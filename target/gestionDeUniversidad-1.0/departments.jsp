<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Department</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5 mb-4">Create new Department</h2>

        <!-- Form to Create Department and Assign Degrees -->
        <form action="department" method="post">
            <!-- Department Name -->
            <div class="form-group">
                <label for="departmentName">Department Name:</label>
                <input type="text" class="form-control" id="departmentName" name="departmentName" placeholder="Enter department name" required>
            </div>
            <div class="form-group">
                <label for="departmentBoss">Department Boss:</label>
                <input type="text" class="form-control" id="departmentBoss" name="departmentBoss" placeholder="Enter department boss" required>
            </div>

            <button type="submit" class="btn btn-primary">Create Department</button>
        </form>
        
        <h2 class="mt-5 mb-4">List of Departments</h2>

        
        <!-- Table to List Departments -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Department Name</th>
                    <th>Department Boss</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="department" items="${departments}">
                    <tr>
                        <td>${department.name}</td>
                        <td>${department.departmentBoss}</td>
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
