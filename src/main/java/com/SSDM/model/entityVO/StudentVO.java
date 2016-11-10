package com.SSDM.model.entityVO;

import java.io.Serializable;

/**
 * Created by Daniil on 09.11.2016.
 */
public class StudentVO implements Serializable {

    private Long studentId;
    private String firstName;
    private String lastName;
    private StudentGroupVO studentGroup;
    //private List<MarkVO> marks;


    public StudentVO() {
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
}
