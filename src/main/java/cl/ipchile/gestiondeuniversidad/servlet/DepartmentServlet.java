package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Department;
import cl.ipchile.gestiondeuniversidad.service.DepartmentService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {

    @EJB
    private DepartmentService departmentService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // List all departments
        request.setAttribute("departments", departmentService.getAllDepartments());
        request.getRequestDispatcher("/departments.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentName = request.getParameter("departmentName");
        String departmentBoss = request.getParameter("departmentBoss");

        if (departmentName != null) {
            // Crear el nuevo departamento
            Department department = new Department();
            department.setName(departmentName);
            department.setDepartmentBoss(departmentBoss);
            departmentService.createDepartment(department);

            // Redirigir a una página de confirmación
            response.sendRedirect("department");
        } else {
            // Redirigir a una página de error si los datos no son válidos
            response.sendRedirect("error.jsp");
        }
    }
}
