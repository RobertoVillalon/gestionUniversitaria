package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import cl.ipchile.gestiondeuniversidad.service.CourseService;
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
    
    @EJB
    private CourseService courseService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Student student;
        switch(action){
            case "create" :
                Long degreeId = Long.valueOf(request.getParameter("degree_id"));

                // Crear un nuevo estudiante
                student = new Student();
                student.setName(request.getParameter("name"));
                student.setFirstLastName(request.getParameter("firstLastName"));
                student.setSecondLastName(request.getParameter("secondLastName"));
                student.setRun(request.getParameter("run"));
                student.setAge(Integer.parseInt(request.getParameter("age")));
                student.setEmail(request.getParameter("email"));
                student.setPassword(request.getParameter("password"));
                student.setDegree(degreeService.getDegree(degreeId));

                studentService.createStudent(student);

                // Redirigir de nuevo a la página de lista de estudiantes
                response.sendRedirect("student?action=view");
            break;
            case "update":
                Long studentId = Long.valueOf(request.getParameter("studentId"));
                
                student = studentService.getStudent(studentId);
                student.setName(request.getParameter("name"));
                student.setFirstLastName(request.getParameter("firstLastName"));
                student.setSecondLastName(request.getParameter("secondLastName"));
                student.setRun(request.getParameter("run"));
                student.setAge(Integer.parseInt(request.getParameter("age")));
                student.setEmail(request.getParameter("email"));
                student.setPassword(request.getParameter("password"));                
                
                studentService.updateStudent(student);
                response.sendRedirect("student?action=view");

            break;

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Student> students;
        List<Degree> degrees;
        List<Course> courses;
        Long studentId;
        Student student;
        
        switch(action){
            case "create":
                request.setAttribute("students", studentService.getAllStudents());
                request.setAttribute("degrees", degreeService.getAllDegrees());

                request.getRequestDispatcher("/pages/student/createStudent.jsp").forward(request, response);
            break;
            case "view":
                request.setAttribute("students", studentService.getAllStudents());
                request.getRequestDispatcher("/pages/student/showStudents.jsp").forward(request, response);
            break;
            case "courses":
                studentId = Long.valueOf(request.getParameter("studentId"));
                request.setAttribute("courses", courseService.findCoursesByStudent(studentId));
                request.getRequestDispatcher("/pages/student/showCoursesByStudent.jsp").forward(request, response);
            break;
            case "update":
                studentId = Long.valueOf(request.getParameter("id"));
     
                request.setAttribute("student", studentService.getStudent(studentId));
                request.setAttribute("degrees", degreeService.getAllDegrees());
                request.getRequestDispatcher("/pages/student/updateStudent.jsp").forward(request, response);
            break;
            case "delete":
                studentId = Long.valueOf(request.getParameter("id"));
                studentService.deleteStudent(studentId);
                students = studentService.getAllStudents();
                
                request.setAttribute("students", students);
                request.getRequestDispatcher("/pages/student/showStudents.jsp").forward(request, response);
            break;
        }
    }
}
