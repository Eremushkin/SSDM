package com.SSDM.model.repository;

import com.SSDM.model.entity.StudentGroup;
import com.google.gwt.user.client.rpc.IsSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long>, IsSerializable {

    @Query("select g from StudentGroup g where g.groupNumber = ?1")
    StudentGroup findByGroupNumber(String groupNumber);
}
