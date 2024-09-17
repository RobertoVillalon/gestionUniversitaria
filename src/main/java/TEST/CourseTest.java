import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Professor;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseTest {

    private Course course;

    @Mock
    private Degree degreeMock;

    @Mock
    private Professor professorMock;

    @Mock
    private Student studentMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks
        List<Student> students = new ArrayList<>();
        students.add(studentMock);
        course = new Course("Matemáticas", degreeMock, professorMock, students);
    }

    @Test
    public void testCourseConstructor() {
        assertNotNull(course);
        assertEquals("Matemáticas", course.getName());
        assertEquals(degreeMock, course.getDegree());
        assertEquals(professorMock, course.getProfessor());
        assertNotNull(course.getStudents());
        assertEquals(1, course.getStudents().size());
    }

    @Test
    public void testSetName() {
        course.setName("Física");
        assertEquals("Física", course.getName());
    }

    @Test
    public void testSetDegree() {
        Degree newDegree = mock(Degree.class);
        course.setDegree(newDegree);
        assertEquals(newDegree, course.getDegree());
    }

    @Test
    public void testSetProfessor() {
        Professor newProfessor = mock(Professor.class);
        course.setProfessor(newProfessor);
        assertEquals(newProfessor, course.getProfessor());
    }

    @Test
    public void testSetStudents() {
        List<Student> newStudents = new ArrayList<>();
        course.setStudents(newStudents);
        assertEquals(newStudents, course.getStudents());
    }
}