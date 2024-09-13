package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import cl.ipchile.gestiondeuniversidad.service.DegreeService;
import cl.ipchile.gestiondeuniversidad.service.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
 @EJB
    private StudentService studentService;

    @EJB
    private DegreeService degreeService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String firstLastName = request.getParameter("firstLastName");
        String secondLastName = request.getParameter("secondLastName");
        String run = request.getParameter("run");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Long degreeId = Long.valueOf(request.getParameter("degree_id"));

        Degree degree = degreeService.getDegree(degreeId);

        // Crear un nuevo estudiante
        Student student = new Student();
        student.setName(name);
        student.setFirstLastName(firstLastName);
        student.setSecondLastName(secondLastName);
        student.setRun(run);
        student.setAge(age);
        student.setEmail(email);
        student.setPassword(password);
        student.setDegree(degree);

        studentService.createStudent(student);

        // Redirigir de nuevo a la página de lista de estudiantes
        response.sendRedirect("student");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        List<Degree> degrees = degreeService.getAllDegrees();

        request.setAttribute("students", students);
        request.setAttribute("degrees", degrees);

        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}
