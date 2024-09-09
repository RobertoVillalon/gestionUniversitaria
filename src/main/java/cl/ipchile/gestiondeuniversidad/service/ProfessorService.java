package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Professor;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class ProfessorService {

    @PersistenceContext
    private EntityManager em;

    public void createProfessor(Professor professor) {
        em.persist(professor);
    }

    public Professor getProfessor(Long id) {
        return em.find(Professor.class, id);
    }

    public List<Professor> getAllProfessors() {
        return em.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
    }

    public void updateProfessor(Professor professor) {
        em.merge(professor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = getProfessor(id);
        if (professor != null) {
            em.remove(professor);
        }
    }
}
