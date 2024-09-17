package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Degree;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DegreeServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private DegreeService degreeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateDegree() {
        Degree degree = new Degree();
        degreeService.createDegree(degree);
        verify(em, times(1)).persist(degree);
    }

    @Test
    public void testGetDegree() {
        Long id = 1L;
        Degree degree = new Degree();
        when(em.find(Degree.class, id)).thenReturn(degree);
        Degree result = degreeService.getDegree(id);
        assertEquals(degree, result);
    }

    @Test
    public void testGetAllDegrees() {
        List<Degree> degrees = new ArrayList<>();
        degrees.add(new Degree());
        degrees.add(new Degree());
        Query query = mock(Query.class);
        when(query.getResultList()).thenReturn(degrees);
        when(em.createQuery("SELECT d FROM Degree d", Degree.class)).thenReturn((TypedQuery<Degree>) query);
        List<Degree> result = degreeService.getAllDegrees();
        assertEquals(degrees, result);
    }

    @Test
    public void testUpdateDegree() {
        Degree degree = new Degree();
        degreeService.updateDegree(degree);
        verify(em, times(1)).merge(degree);
    }

    @Test
    public void testDeleteDegree() {
        Long id = 1L;
        Degree degree = new Degree();
        when(em.find(Degree.class, id)).thenReturn(degree);
        degreeService.deleteDegree(id);
        verify(em, times(1)).remove(degree);
    }

    @Test
    public void testDeleteDegreeNotFound() {
        Long id = 1L;
        when(em.find(Degree.class, id)).thenReturn(null);
        degreeService.deleteDegree(id);
        verify(em, never()).remove(any(Degree.class));
    }
}