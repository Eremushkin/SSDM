package com.SSDM.model.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniil on 05.10.2016.
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private long teacherId;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "last_name", length = 32)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id", referencedColumnName = "subject_id"))
    private List<Subject> subjects;

    /*
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "teachers", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Subject> subjects;
    */

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }
}
