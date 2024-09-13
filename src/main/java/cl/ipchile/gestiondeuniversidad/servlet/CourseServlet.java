package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Professor;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import cl.ipchile.gestiondeuniversidad.service.CourseService;
import cl.ipchile.gestiondeuniversidad.service.DegreeService;
import cl.ipchile.gestiondeuniversidad.service.ProfessorService;
import cl.ipchile.gestiondeuniversidad.service.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    @EJB
    private CourseService courseService;

    @EJB
    private DegreeService degreeService;

    @EJB
    private ProfessorService professorService;
    
    @EJB
    private StudentService studentService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
                
        if(action.equals("create")){
            List<Course> courses = courseService.getAllCourses();
            List<Degree> degrees = degreeService.getAllDegrees();
            List<Professor> professors = professorService.getAllProfessors();

            request.setAttribute("courses", courses);
            request.setAttribute("degrees", degrees);
            request.setAttribute("professors", professors);

            request.getRequestDispatcher("/courses.jsp").forward(request, response); 
        }else if(action.equals("assign")){
            List<Student> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            List<Course> courses = courseService.getAllCourses();
            request.setAttribute("courses", courses);

            request.getRequestDispatcher("/studentByCourse.jsp").forward(request, response); 
        }else if(action.equals("studentCourse")){
                    System.out.println("si entra");

            Long studentId = Long.valueOf(request.getParameter("studentId"));

            List<Course> courses = courseService.findCoursesByStudent(studentId);

            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/coursesByStudent.jsp").forward(request, response);
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if(action.equals("create")){
            String courseName = request.getParameter("name");
            Long degreeId = Long.valueOf(request.getParameter("degreeId"));
            Long professorId = Long.valueOf(request.getParameter("professorId"));
            String[] studentIds = request.getParameterValues("studentIds");

            Degree degree = degreeService.getDegree(degreeId);
            Professor professor = professorService.getProfessor(professorId);
            List<Student> students = new ArrayList<>();

            if (studentIds != null) {
                for (String studentId : studentIds) {
                    students.add(studentService.getStudent(Long.valueOf(studentId)));
                }
            }

            // Crear un nuevo curso
            Course course = new Course();
            course.setName(courseName);
            course.setDegree(degree);
            course.setProfessor(professor);
            course.setStudents(students);

            courseService.createCourse(course);

            // Redirigir de nuevo a la página de lista de cursos
            response.sendRedirect("course?action=create");
        }else if(action.equals("assign")){
            Long courseId = Long.valueOf(request.getParameter("courseId"));
            Course course = courseService.getCourse(courseId);
            List<Student> lista = course.getStudents();
            lista.add(studentService.getStudent(Long.valueOf(request.getParameter("studentId"))));
            
            course.setStudents(lista);
          
            courseService.updateCourse(course);

            response.sendRedirect("course?action=assign");
        }else if(action.equals("studentCourse")){
            
        }

        
    }

}
