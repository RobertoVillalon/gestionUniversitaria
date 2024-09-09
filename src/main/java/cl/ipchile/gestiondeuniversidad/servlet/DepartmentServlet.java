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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new department
        String name = request.getParameter("name");

        Department department = new Department(name, null, null);
        departmentService.createDepartment(department);
        response.sendRedirect("department");
    }
}
