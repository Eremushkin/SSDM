package com.SSDM.model.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="group_id", nullable = false)
    private StudentGroup studentGroup;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderBy("date")
    private List<Mark> marks;

    public Student() {
    }
    public Student(String firstName, String lastName, StudentGroup studentGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentGroup = studentGroup;
    }

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public List<Mark> getMarks() {
        return marks;
    }
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "{"
                + " studentId = " + studentId
                + " firstName = " + firstName
                + " lastName = " + lastName
                + " }";
    }
}
