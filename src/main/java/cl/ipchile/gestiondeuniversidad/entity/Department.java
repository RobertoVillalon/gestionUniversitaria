package cl.ipchile.gestiondeuniversidad.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Degree> degrees;

    private String departmentBoss;

    public Department() {
    }

    public Department(String name, List<Degree> degrees, String departmentBoss) {
        this.name = name;
        this.degrees = degrees;
        this.departmentBoss = departmentBoss;
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

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public String getDepartmentBoss() {
        return departmentBoss;
    }

    public void setDepartmentBoss(String departmentBoss) {
        this.departmentBoss = departmentBoss;
    }
    
    

}
