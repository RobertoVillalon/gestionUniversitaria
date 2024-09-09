/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.ipchile.gestiondeuniversidad.entity;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "degree")
public class Degree implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false, length = 100)
    private String degreeBoss;

    public Degree() {
    }

    public Degree(String name, Department department, String degreeBoss) {
        this.name = name;
        this.department = department;
        this.degreeBoss = degreeBoss;
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

    public Department getDepartament() {
        return department;
    }

    public void setDepartament(Department department) {
        this.department = department;
    }

    public String getDegreeBoss() {
        return degreeBoss;
    }

    public void setDegreeBoss(String degreeBoss) {
        this.degreeBoss = degreeBoss;
    }
    
}
