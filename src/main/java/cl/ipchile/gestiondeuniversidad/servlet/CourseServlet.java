package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.service.CourseService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    @EJB
    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Asegúrate de que la inyección haya sido realizada correctamente
        if (courseService == null) {
            throw new ServletException("courseService no inyectado correctamente");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // List all courses
        request.setAttribute("courses", courseService.getAllCourses());
        request.getRequestDispatcher("/courses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new course
        String name = request.getParameter("name");
        // Additional fields and logic to set career and professor

        Course course = new Course(name, null, null, null);
        courseService.createCourse(course);
        response.sendRedirect("course");
    }
}
