<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Degree</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5 mb-4">Create a New Degree</h2>

        <!-- Form to Create Degree -->
        <form action="degree" method="post">
            <!-- Degree Name -->
            <div class="form-group">
                <label for="degreeName">Degree Name:</label>
                <input type="text" class="form-control" id="degreeName" name="degreeName" placeholder="Enter degree name" required>
            </div>

            <!-- Degree Boss -->
            <div class="form-group">
                <label for="degreeBoss">Degree Boss:</label>
                <input type="text" class="form-control" id="degreeBoss" name="degreeBoss" placeholder="Enter degree boss name" required>
            </div>

            <!-- Select Department -->
            <div class="form-group">
                <label for="department">Select Department:</label>
                <select name="departmentId" id="department" class="form-control" required>
                    <c:forEach var="department" items="${departments}">
                        <option value="${department.id}">${department.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Degree</button>
        </form>
        
        <h3>Degree List</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Degree Boss</th>
                    <th>Name</th>
                    <th>Department</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="degree" items="${degrees}">
                    <tr>
                        <td>${degree.id}</td>
                        <td>${degree.degreeBoss}</td>
                        <td>${degree.name}</td>
                        <td>${degree.department.name}</td>
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
