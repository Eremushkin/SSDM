package com.SSDM.model.entityVO;

import java.io.Serializable;
import java.sql.Date;


public class MarkVO implements Serializable{

    private long markId;
    private int mark;
    private Date date;

    private StudentVO student;
    private SubjectVO subject;
    private TeacherVO teacher;

    public MarkVO() {
    }

    public MarkVO(int mark, Date date, StudentVO student, SubjectVO subject, TeacherVO teacher) {
        this.mark = mark;
        this.date = date;
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
    }

    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StudentVO getStudent() {
        return student;
    }

    public void setStudent(StudentVO student) {
        this.student = student;
    }

    public SubjectVO getSubject() {
        return subject;
    }

    public void setSubject(SubjectVO subject) {
        this.subject = subject;
    }

    public TeacherVO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVO teacher) {
        this.teacher = teacher;
    }
}
