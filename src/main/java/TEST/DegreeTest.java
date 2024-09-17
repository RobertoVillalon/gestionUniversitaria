import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Department;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DegreeTest {

    private Degree degree;
    private Department department;

    @BeforeEach
    public void setUp() {
        department = new Department(); // Puedes ajustar esto según tu implementación de Department
        department.setId(1L);
        department.setName("Engineering");

        degree = new Degree("Computer Science", department, "John Doe");
    }

    @Test
    public void testDegreeConstructor() {
        assertEquals("Computer Science", degree.getName());
        assertEquals(department, degree.getDepartment());
        assertEquals("John Doe", degree.getDegreeBoss());
    }

    @Test
    public void testSetName() {
        degree.setName("Mathematics");
        assertEquals("Mathematics", degree.getName());
    }

    @Test
    public void testSetDepartment() {
        Department newDepartment = new Department(); // Suponiendo que la clase Department existe
        newDepartment.setId(2L);
        newDepartment.setName("Science");

        degree.setDepartment(newDepartment);
        assertEquals(newDepartment, degree.getDepartment());
    }

    @Test
    public void testSetDegreeBoss() {
        degree.setDegreeBoss("Jane Doe");
        assertEquals("Jane Doe", degree.getDegreeBoss());
    }

    @Test
    public void testSetId() {
        degree.setId(10L);
        assertEquals(10L, degree.getId());
    }
}