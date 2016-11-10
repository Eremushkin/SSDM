package com.SSDM.model.entityVO;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniil on 09.11.2016.
 */
public class StudentGroupVO implements Serializable {

    private long groupId;
    private String groupNumber;
    private List<StudentVO> students;

    public StudentGroupVO() {
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<StudentVO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentVO> students) {
        this.students = students;
    }
}
