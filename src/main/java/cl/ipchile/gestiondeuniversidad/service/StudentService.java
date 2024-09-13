package cl.ipchile.gestiondeuniversidad.service;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class StudentService {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    public void createStudent(Student student) {
        em.persist(student);
    }

    public Student getStudent(Long id) {
        return em.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void updateStudent(Student student) {
        em.merge(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        if (student != null) {
            em.remove(student);
        }
    }
    
    public List<Student> getStudentsByCourse(Long courseId) {
        return em.createQuery(
                "SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId", Student.class)
                .setParameter("courseId", courseId)
                .getResultList();
    }
}
