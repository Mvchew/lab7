package ca.sait.lab7.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Represent a role
 * @author Melvin Chew
 */
@Entity
@Table(name="role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})
public class Role implements Serializable {
    @Id
    @Basic
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String name;

    @OneToMany
    private List<User> user;

    public Role() {
    
    }

    public Role(int id, String name) {
        
        this.id = id;
        this.name = name; 
    }   

    public Role(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
