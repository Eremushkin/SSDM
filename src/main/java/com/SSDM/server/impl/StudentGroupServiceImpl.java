package com.SSDM.server.impl;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.service.StudentGroupSpringDataService;
import com.SSDM.server.AutowiringRemoteServiceServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGroupServiceImpl extends AutowiringRemoteServiceServlet implements StudentGroupService {



    @Autowired
    private transient StudentGroupSpringDataService service;

   /* @Override
    public void addOrUpdate(StudentGroup studentGroup) {
        service.addOrUpdate(studentGroup);
    }*/

    @Override
    public List<StudentGroupVO> getAll() {
        return service.getAll();
    }

    @Override
    public StudentGroupVO getByNumber(String number) {
        return service.getByNumber(number);
    }
}


