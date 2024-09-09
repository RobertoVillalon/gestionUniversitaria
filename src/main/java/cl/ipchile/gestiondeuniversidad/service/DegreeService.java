package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Degree;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class DegreeService {

    @PersistenceContext
    private EntityManager em;

    public void createDegree(Degree degree) {
        em.persist(degree);
    }

    public Degree getDegree(Long id) {
        return em.find(Degree.class, id);
    }

    public List<Degree> getAllDegrees() {
        return em.createQuery("SELECT d FROM Degree d", Degree.class).getResultList();
    }

    public void updateDegree(Degree degree) {
        em.merge(degree);
    }

    public void deleteDegree(Long id) {
        Degree degree = getDegree(id);
        if (degree != null) {
            em.remove(degree);
        }
    }
}
