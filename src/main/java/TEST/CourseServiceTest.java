package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Course;
import cl.ipchile.gestiondeuniversidad.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CourseServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCourse() {
        Course course = new Course();
        courseService.createCourse(course);
        verify(em, times(1)).persist(course);
    }

    @Test
    public void testGetCourse() {
        Long courseId = 1L;
        Course course = new Course();
        when(em.find(Course.class, courseId)).thenReturn(course);

        Course result = courseService.getCourse(courseId);
        verify(em, times(1)).find(Course.class, courseId);
        assert(result == course);
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = Arrays.asList(new Course(), new Course());
        TypedQuery<Course> query = mock(TypedQuery.class);
        when(em.createQuery("SELECT c FROM Course c", Course.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(courses);

        List<Course> result = courseService.getAllCourses();
        verify(em, times(1)).createQuery("SELECT c FROM Course c", Course.class);
        assert(result.equals(courses));
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        courseService.updateCourse(course);
        verify(em, times(1)).merge(course);
    }

    @Test
    public void testDeleteCourse() {
        Long courseId = 1L;
        Course course = new Course();
        when(em.find(Course.class, courseId)).thenReturn(course);

        courseService.deleteCourse(courseId);
        verify(em, times(1)).remove(course);
    }

    @Test
    public void testFindCoursesByStudent() {
        Long studentId = 1L;
        List<Course> courses = Arrays.asList(new Course(), new Course());
        TypedQuery<Course> query = mock(TypedQuery.class);
        when(em.createQuery("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId", Course.class))
            .thenReturn(query);
        when(query.setParameter("studentId", studentId)).thenReturn(query);
        when(query.getResultList()).thenReturn(courses);

        List<Course> result = courseService.findCoursesByStudent(studentId);
        verify(em, times(1)).createQuery("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId", Course.class);
        assert(result.equals(courses));
    }

    @Test
    public void testRemoveAllStudentFromCourse() {
        Course course = new Course();
        List<Student> students = Arrays.asList(new Student(), new Student());
        course.setStudents(students);

        courseService.removeAllStudentFromCourse(course);
        verify(em, times(1)).merge(course);
        assert(course.getStudents().isEmpty());
    }

    @Test
    public void testRemoveStudentFromCourse() {
        Student studentToRemove = new Student();
        studentToRemove.setId(1L);
        Course course = new Course();
        List<Student> students = Arrays.asList(studentToRemove, new Student());
        course.setStudents(students);

        courseService.removeStudentFromCourse(studentToRemove, course);
        verify(em, times(1)).merge(course);
        assert(course.getStudents().size() == 1);
    }
}