<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assign Students to Courses</title>
</head>
<body>
    <h2>Assign Student to Course</h2>

    <!-- Formulario para asignar estudiantes a cursos -->
    <form action="course" method="post">
        <input type="hidden" name="action" value="assign" />

        <!-- Dropdown para seleccionar el estudiante -->
        <label for="student">Select Student:</label>
        <select name="studentId" id="student">
            <c:forEach var="student" items="${students}">
                <option value="${student.id}">
                    ${student.name} ${student.firstLastName} ${student.secondLastName} 
                </option>
            </c:forEach>
        </select>
        <br><br>

        <!-- Dropdown para seleccionar el curso -->
        <label for="course">Select Course:</label>
        <select name="courseId" id="course">
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">
                    ${course.name}
                </option>
            </c:forEach>
        </select>
        <br><br>

        <!-- Botón de envío -->
        <button type="submit">Assign Student to Course</button>
    </form>

    <form action="course" method="get">
        <input type="hidden" name="action" value="create" />
        <button class="btn btn-primary" type="submit">ir a crear curso</button>
    </form>
</body>
</html>