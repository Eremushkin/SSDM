package com.SSDM.model.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "last_name", length = 32)
    private String lastName;

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="group_id", nullable = false)
    private StudentGroup studentGroup;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Mark> marks;*/

    public Student() {
    }
   public Student(String firstName, String lastName, StudentGroup studentGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentGroup = studentGroup;
    }

    public Long getId(){
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    /*public List<Mark> getMarks() {
        return marks;
    }*/


    @Override
    public String toString() {
        return "{"
                + " studentId = " + studentId
                + " firstName = " + firstName
                + " lastName = " + lastName
                + " }";
    }
}
