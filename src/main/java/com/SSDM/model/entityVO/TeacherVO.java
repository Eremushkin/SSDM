package com.SSDM.model.entityVO;

import java.io.Serializable;
import java.util.List;

public class TeacherVO implements Serializable {

    private long teacherId;
    private String firstName;
    private String lastName;
    private String middleName;

    private List<SubjectVO> subjects;

    public TeacherVO() {
    }

    public TeacherVO(String firstName, String lastName, String middleName) {
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

    public List<SubjectVO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectVO> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName;
    }
}
