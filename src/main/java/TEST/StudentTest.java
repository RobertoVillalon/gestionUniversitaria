import cl.ipchile.gestiondeuniversidad.entity.Degree;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentCreation() {
        Degree degree = new Degree();
        Student student = new Student("Juan", "Pérez", "López", "12345678-9", 20, "juan.perez@gmail.com", "password123", degree);

        assertEquals("Juan", student.getName());
        assertEquals("Pérez", student.getFirstLastName());
        assertEquals("López", student.getSecondLastName());
        assertEquals("12345678-9", student.getRun());
        assertEquals(20, student.getAge());
        assertEquals("juan.perez@gmail.com", student.getEmail());
        assertEquals("password123", student.getPassword());
        assertEquals(degree, student.getDegree());
    }
    
    
    @Test
    void testSettersAndGetters() {
        Student student = new Student();
        Degree degree = new Degree();

        student.setName("Ana");
        student.setFirstLastName("García");
        student.setSecondLastName("Martínez");
        student.setRun("98765432-1");
        student.setAge(22);
        student.setEmail("ana.garcia@gmail.com");
        student.setPassword("securepass456");
        student.setDegree(degree);

        assertEquals("Ana", student.getName());
        assertEquals("García", student.getFirstLastName());
        assertEquals("Martínez", student.getSecondLastName());
        assertEquals("98765432-1", student.getRun());
        assertEquals(22, student.getAge());
        assertEquals("ana.garcia@gmail.com", student.getEmail());
        assertEquals("securepass456", student.getPassword());
        assertEquals(degree, student.getDegree());
    }
    
    
    @Test
    void testNullFields() {
        Student student = new Student();
        
        assertThrows(NullPointerException.class, () -> {
            student.setName(null); // name no debería ser nulo
        });
        
        assertThrows(NullPointerException.class, () -> {
            student.setEmail(null); // email no debería ser nulo
        });
    }
    
    
}
