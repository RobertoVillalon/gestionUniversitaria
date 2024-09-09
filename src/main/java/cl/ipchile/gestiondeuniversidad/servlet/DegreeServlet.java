package cl.ipchile.gestiondeuniversidad.servlet;
import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.service.DegreeService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/degree")
public class DegreeServlet extends HttpServlet {

    @EJB
    private DegreeService degreeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // List all degrees
        request.setAttribute("degrees", degreeService.getAllDegrees());
        request.getRequestDispatcher("/degrees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new degree
        String name = request.getParameter("name");

        Degree degree = new Degree(name, null, null);
        degreeService.createDegree(degree);
        response.sendRedirect("degree");
    }
}
