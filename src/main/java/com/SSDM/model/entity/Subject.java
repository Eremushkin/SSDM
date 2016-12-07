package com.SSDM.model.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private long subjectId;
    @Column(name = "subject_name", length = 50)
    private String subjectName;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    private List<Teacher> teachers;
    /*@ManyToMany
    @JoinTable(name = "teacher_subject",
                joinColumns = @JoinColumn(name="subject_id", referencedColumnName = "subject_id"),
                inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"))
    private List<Teacher> teachers;*/

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
