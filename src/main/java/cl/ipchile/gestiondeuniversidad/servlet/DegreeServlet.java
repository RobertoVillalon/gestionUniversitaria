package cl.ipchile.gestiondeuniversidad.servlet;
import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Department;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import cl.ipchile.gestiondeuniversidad.service.DegreeService;
import cl.ipchile.gestiondeuniversidad.service.DepartmentService;
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

@WebServlet("/degree")
public class DegreeServlet extends HttpServlet {

    @EJB
    private DegreeService degreeService;

    @EJB
    private DepartmentService departmentService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // List all degrees
        request.setAttribute("departments", departmentService.getAllDepartments());
        request.setAttribute("degrees", degreeService.getAllDegrees());
        request.getRequestDispatcher("/degrees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String degreeName = request.getParameter("degreeName");
        String degreeBoss = request.getParameter("degreeBoss");
        String departmentId = request.getParameter("departmentId");

        if (degreeName != null && degreeBoss != null && departmentId != null) {
            // Buscar el departamento asociado
            Department department = departmentService.getDepartment(Long.valueOf(departmentId));

            // Crear la nueva carrera
            Degree degree = new Degree();
            degree.setName(degreeName);
            degree.setDegreeBoss(degreeBoss);
            degree.setDepartment(department);

            // Guardar la nueva carrera
            degreeService.createDegree(degree);

            // Redirigir a una página de confirmación
            response.sendRedirect("degree");
        } else {
            // Redirigir a una página de error si los datos no son válidos
            response.sendRedirect("error.jsp");
        }
    }
}
