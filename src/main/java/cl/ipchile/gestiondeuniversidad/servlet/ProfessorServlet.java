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
import java.util.List;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
@EJB
    private ProfessorService professorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Professor> professors = professorService.getAllProfessors();
        request.setAttribute("professors", professors);
        request.getRequestDispatcher("/professors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String firstLastName = request.getParameter("firstlastname");
        String secondLastName = request.getParameter("secondlastname");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String run = request.getParameter("run");
        String password = request.getParameter("password");

        // Crear un nuevo profesor
        Professor professor = new Professor();
        professor.setName(name);
        professor.setFirstLastName(firstLastName);
        professor.setSecondLastName(secondLastName);
        professor.setAge(age);
        professor.setEmail(email);
        professor.setRun(run);
        professor.setPassword(password);

        professorService.createProfessor(professor);

        // Redirigir de nuevo a la página de lista de profesores
        response.sendRedirect("professor");
    }
}
