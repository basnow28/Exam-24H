package kea.exam.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int student_id;

    @NotNull
    @Column(name="student_name", length = 25)
    private String student_name;

    @NotNull
    @Column(name="student_email", length = 25)
    private String student_email;

    @NotNull
    @ManyToOne
    private Supervisor supervisor;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
