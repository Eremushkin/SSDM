package com.SSDM.model.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private long markId;
    @Column(name = "mark")
    private int mark;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    public Mark() {
    }
    public Mark(int mark, Student student, Subject subject) {
        this.mark = mark;
        this.student = student;
        this.subject = subject;
    }

    public long getMarkId() {
        return markId;
    }

    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
