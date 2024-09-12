<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student Management</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
            }
        </style>
    </head>
    <body>

    <h2>Student Management</h2>

    <!-- Form to create a new student -->
    <h3>Create New Student</h3>
    <form action="student" method="POST">
        <label for="name">First Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="lastNameP">First Last Name:</label><br>
        <input type="text" id="firstLastName" name="firstLastName" required><br><br>

        <label for="lastNameM">Second Last Name:</label><br>
        <input type="text" id="secondLastName" name="secondLastName" required><br><br>

        <label for="rut">RUT:</label><br>
        <input type="text" id="rut" name="rut" required><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Submit</button>
    </form>

    <hr>

    <!-- List of students -->
    <h3>Student List</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name (Paternal)</th>
                <th>Last Name (Maternal)</th>
                <th>RUT</th>
                <th>Age</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.firstLastName}</td>
                    <td>${student.secondLastName}</td>
                    <td>${student.run}</td>
                    <td>${student.age}</td>
                    <td>${student.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    </body>
</html>
