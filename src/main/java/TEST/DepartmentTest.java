import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Department;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class DepartmentTest {

    private Department department;
    private List<Degree> degreeList;

    @BeforeEach
    void setUp() {
        degreeList = new ArrayList<>();
        department = new Department("Engineering", degreeList, "Dr. Roberto Villalon");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Engineering", department.getName());
        assertEquals(degreeList, department.getDegrees());
        assertEquals("Dr. Roberto Villalon", department.getDepartmentBoss());
    }

    @Test
    void testSetters() {
        department.setName("Science");
        assertEquals("Science", department.getName());

        Degree degree = new Degree();  // asumiendo que Degree es otra entidad que ya existe
        List<Degree> newDegreeList = new ArrayList<>();
        newDegreeList.add(degree);
        department.setDegrees(newDegreeList);
        assertEquals(newDegreeList, department.getDegrees());

        department.setDepartmentBoss("Dr. Victoria Villalon");
        assertEquals("Dr. Victoria Villalon", department.getDepartmentBoss());
    }

    @Test
    void testSetId() {
        department.setId(1L);
        assertEquals(1L, department.getId());
    }
}