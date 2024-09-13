package cl.ipchile.gestiondeuniversidad.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_degree", referencedColumnName = "id")
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor professor;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "id_course"),
        inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private List<Student> students;

    // Constructores, Getters y Setters

    public Course() {
    }

    public Course(String name, Degree degree, Professor professor, List<Student> students) {
        this.name = name;
        this.degree = degree;
        this.professor = professor;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
    
}

