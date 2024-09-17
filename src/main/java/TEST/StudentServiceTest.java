package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStudent() {
        // Arrange
        Student student = new Student();
        
        // Act
        studentService.createStudent(student);

        // Assert
        verify(em, times(1)).persist(student);
    }

    @Test
    void getStudent() {
        // Arrange
        Long studentId = 1L;
        Student expectedStudent = new Student();
        when(em.find(Student.class, studentId)).thenReturn(expectedStudent);

        // Act
        Student result = studentService.getStudent(studentId);

        // Assert
        assertEquals(expectedStudent, result);
        verify(em, times(1)).find(Student.class, studentId);
    }

    @Test
    void getAllStudents() {
        // Arrange
        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> expectedStudents = Arrays.asList(student1, student2);
        when(em.createQuery("SELECT s FROM Student s", Student.class).getResultList()).thenReturn(expectedStudents);

        // Act
        List<Student> result = studentService.getAllStudents();

        // Assert
        assertEquals(expectedStudents, result);
        verify(em, times(1)).createQuery("SELECT s FROM Student s", Student.class);
    }

    @Test
    void updateStudent() {
        // Arrange
        Student student = new Student();

        // Act
        studentService.updateStudent(student);

        // Assert
        verify(em, times(1)).merge(student);
    }

    @Test
    void deleteStudent() {
        // Arrange
        Long studentId = 1L;
        Student student = new Student();
        when(em.find(Student.class, studentId)).thenReturn(student);

        // Act
        studentService.deleteStudent(studentId);

        // Assert
        verify(em, times(1)).remove(student);
    }

    @Test
    void deleteStudent_notFound() {
        // Arrange
        Long studentId = 1L;
        when(em.find(Student.class, studentId)).thenReturn(null);

        // Act
        studentService.deleteStudent(studentId);

        // Assert
        verify(em, never()).remove(any(Student.class));
    }

    @Test
    void getStudentsByCourse() {
        // Arrange
        Long courseId = 1L;
        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> expectedStudents = Arrays.asList(student1, student2);
        when(em.createNativeQuery("SELECT s.* FROM Student s JOIN student_course sc ON s.id = sc.id_student WHERE sc.id_course = ?", Student.class)
                .setParameter(1, courseId)
                .getResultList()).thenReturn(expectedStudents);

        // Act
        List<Student> result = studentService.getStudentsByCourse(courseId);

        // Assert
        assertEquals(expectedStudents, result);
        verify(em, times(1)).createNativeQuery("SELECT s.* FROM Student s JOIN student_course sc ON s.id = sc.id_student WHERE sc.id_course = ?", Student.class);
    }
}