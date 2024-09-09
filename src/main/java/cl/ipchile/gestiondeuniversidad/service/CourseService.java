package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Course;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class CourseService {

    @PersistenceContext
    private EntityManager em;

    public void createCourse(Course course) {
        em.persist(course);
    }

    public Course getCourse(Long id) {
        return em.find(Course.class, id);
    }

    public List<Course> getAllCourses() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public void updateCourse(Course course) {
        em.merge(course);
    }

    public void deleteCourse(Long id) {
        Course course = getCourse(id);
        if (course != null) {
            em.remove(course);
        }
    }
}
