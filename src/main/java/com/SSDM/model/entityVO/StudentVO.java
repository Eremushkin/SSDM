package com.SSDM.model.entityVO;

import java.io.Serializable;
import java.util.List;

public class StudentVO implements Serializable {

    private long studentId;
    private String firstName;
    private String lastName;

    private StudentGroupVO studentGroup;
    private List<MarkVO> marks;


    public StudentVO() {

    }

    public StudentVO(String firstName, String lastName, StudentGroupVO studentGroup) {
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

    public StudentGroupVO getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroupVO studentGroup) {
        this.studentGroup = studentGroup;
    }

    public List<MarkVO> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkVO> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
