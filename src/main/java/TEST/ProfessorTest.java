import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.entity.Professor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ProfessorTest {

    private Professor professor;
    private List<Course> courses;

    @BeforeEach
    public void setUp() {
        courses = new ArrayList<>();
        professor = new Professor("Roberto", "Villalon", "Perez", "12345678-9", 22, "roberto.villalon@ipchile.cl", "password123", courses);
    }

    @Test
    public void testGetName() {
        assertEquals("Roberto", professor.getName());
    }

    @Test
    public void testSetName() {
        professor.setName("Victoria");
        assertEquals("Victoria", professor.getName());
    }

    @Test
    public void testGetFirstLastName() {
        assertEquals("Villalon", professor.getFirstLastName());
    }

    @Test
    public void testSetFirstLastName() {
        professor.setFirstLastName("Johnson");
        assertEquals("Johnson", professor.getFirstLastName());
    }

    @Test
    public void testGetRun() {
        assertEquals("12345678-9", professor.getRun());
    }

    @Test
    public void testSetRun() {
        professor.setRun("98765432-1");
        assertEquals("98765432-1", professor.getRun());
    }

    @Test
    public void testGetEmail() {
        assertEquals("roberto.villalon@ipchile.cl", professor.getEmail());
    }

    @Test
    public void testSetEmail() {
        professor.setEmail("victoria.villalon@ipchile.cl");
        assertEquals("victoria.villalon@ipchile.cl", professor.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", professor.getPassword());
    }

    @Test
    public void testSetPassword() {
        professor.setPassword("newpassword456");
        assertEquals("newpassword456", professor.getPassword());
    }

    @Test
    public void testGetAge() {
        assertEquals(45, professor.getAge());
    }

    @Test
    public void testSetAge() {
        professor.setAge(50);
        assertEquals(50, professor.getAge());
    }

    @Test
    public void testGetCourses() {
        assertEquals(courses, professor.getCourses());
    }

    @Test
    public void testSetCourses() {
        List<Course> newCourses = new ArrayList<>();
        professor.setCourses(newCourses);
        assertEquals(newCourses, professor.getCourses());
    }
}