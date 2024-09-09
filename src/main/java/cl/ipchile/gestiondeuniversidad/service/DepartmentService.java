package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Department;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class DepartmentService {

    @PersistenceContext
    private EntityManager em;

    public void createDepartment(Department department) {
        em.persist(department);
    }

    public Department getDepartment(Long id) {
        return em.find(Department.class, id);
    }

    public List<Department> getAllDepartments() {
        return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }

    public void updateDepartment(Department department) {
        em.merge(department);
    }

    public void deleteDepartment(Long id) {
        Department department = getDepartment(id);
        if (department != null) {
            em.remove(department);
        }
    }
}
