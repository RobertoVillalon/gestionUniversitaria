package cl.ipchile.gestiondeuniversidad.servlet;

import cl.ipchile.gestiondeuniversidad.entity.Professor;
import cl.ipchile.gestiondeuniversidad.service.ProfessorService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {

    @EJB
    private ProfessorService professorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // List all professors
        request.setAttribute("professors", professorService.getAllProfessors());
        request.getRequestDispatcher("/professors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new professor
        String name = request.getParameter("name");
        String lastNameP = request.getParameter("lastNameP");
        String lastNameM = request.getParameter("lastNameM");
        String rut = request.getParameter("rut");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Professor professor = new Professor(name, lastNameP, lastNameM, rut, age, email, password, null);
        professorService.createProfessor(professor);
        response.sendRedirect("professor");
    }
}
