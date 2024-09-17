package cl.ipchile.gestiondeuniversidad.service;

import cl.ipchile.gestiondeuniversidad.entity.Professor;
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

class ProfessorServiceTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private ProfessorService professorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProfessor_shouldPersistProfessor() {
        Professor professor = new Professor();
        professorService.createProfessor(professor);
        verify(em, times(1)).persist(professor);
    }

    @Test
    void getProfessor_shouldReturnProfessorById() {
        Long id = 1L;
        Professor professor = new Professor();
        when(em.find(Professor.class, id)).thenReturn(professor);

        Professor result = professorService.getProfessor(id);
        assertNotNull(result);
        assertEquals(professor, result);
        verify(em, times(1)).find(Professor.class, id);
    }

    @Test
    void getAllProfessors_shouldReturnListOfProfessors() {
        List<Professor> professors = Arrays.asList(new Professor(), new Professor());
        when(em.createQuery("SELECT p FROM Professor p", Professor.class).getResultList()).thenReturn(professors);

        List<Professor> result = professorService.getAllProfessors();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(em, times(1)).createQuery("SELECT p FROM Professor p", Professor.class);
    }

    @Test
    void updateProfessor_shouldMergeProfessor() {
        Professor professor = new Professor();
        professorService.updateProfessor(professor);
        verify(em, times(1)).merge(professor);
    }

    @Test
    void deleteProfessor_shouldRemoveProfessorIfExists() {
        Long id = 1L;
        Professor professor = new Professor();
        when(em.find(Professor.class, id)).thenReturn(professor);

        professorService.deleteProfessor(id);
        verify(em, times(1)).remove(professor);
    }

    @Test
    void deleteProfessor_shouldDoNothingIfProfessorNotExists() {
        Long id = 1L;
        when(em.find(Professor.class, id)).thenReturn(null);

        professorService.deleteProfessor(id);
        verify(em, times(0)).remove(any());
    }
}