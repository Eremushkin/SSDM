package com.SSDM.model.entityVO;

import java.io.Serializable;
import java.util.List;

public class SubjectVO implements Serializable{

    private long subjectId;
    private String subjectName;

    private List<TeacherVO> teachers;

    public SubjectVO() {
    }

    public SubjectVO(String subjectName) {
        this.subjectId = subjectId;
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

    public List<TeacherVO> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
