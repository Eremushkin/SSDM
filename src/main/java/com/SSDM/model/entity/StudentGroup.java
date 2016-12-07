package com.SSDM.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student_group")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private long groupId;

    @Column(name = "group_number")
    private String groupNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentGroup")
    private List<Student> students;

    public StudentGroup() {
    }

    public StudentGroup(String groupNumber) {
        this.groupNumber = groupNumber;
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

   public List<Student> getStudents() {
        return students;
    }
}
