package kea.exam.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="supervisors")
public class Supervisor {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int supervisor_id;

    @NotNull
    @Column(name="supervisor_name")
    private String supervisor_name;

    @OneToMany
    private Collection<Student> students;

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public String getSupervisor_name() {
        return supervisor_name;
    }

    public void setSupervisor_name(String supervisor_name) {
        this.supervisor_name = supervisor_name;
    }
}
