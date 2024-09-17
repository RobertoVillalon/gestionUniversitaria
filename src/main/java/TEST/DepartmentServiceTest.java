package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDepartment() {
        // Given
        Department department = new Department();

        // When
        departmentService.createDepartment(department);

        // Then
        verify(em, times(1)).persist(department);
    }

    @Test
    void getDepartment() {
        // Given
        Long departmentId = 1L;
        Department department = new Department();
        when(em.find(Department.class, departmentId)).thenReturn(department);

        // When
        Department result = departmentService.getDepartment(departmentId);

        // Then
        assertEquals(department, result);
        verify(em, times(1)).find(Department.class, departmentId);
    }

    @Test
    void getAllDepartments() {
        // Given
        Department dept1 = new Department();
        Department dept2 = new Department();
        List<Department> departments = Arrays.asList(dept1, dept2);
        when(em.createQuery("SELECT d FROM Department d", Department.class).getResultList()).thenReturn(departments);

        // When
        List<Department> result = departmentService.getAllDepartments();

        // Then
        assertEquals(departments, result);
        verify(em, times(1)).createQuery("SELECT d FROM Department d", Department.class);
    }

    @Test
    void updateDepartment() {
        // Given
        Department department = new Department();

        // When
        departmentService.updateDepartment(department);

        // Then
        verify(em, times(1)).merge(department);
    }

    @Test
    void deleteDepartment() {
        // Given
        Long departmentId = 1L;
        Department department = new Department();
        when(em.find(Department.class, departmentId)).thenReturn(department);

        // When
        departmentService.deleteDepartment(departmentId);

        // Then
        verify(em, times(1)).remove(department);
    }

    @Test
    void deleteDepartment_NotFound() {
        // Given
        Long departmentId = 1L;
        when(em.find(Department.class, departmentId)).thenReturn(null);

        // When
        departmentService.deleteDepartment(departmentId);

        // Then
        verify(em, never()).remove(any());
    }
}