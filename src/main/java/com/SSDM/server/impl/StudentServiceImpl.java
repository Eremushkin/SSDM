package com.SSDM.server.impl;


import com.SSDM.client.service.studentService.StudentService;

import com.SSDM.controler.service.StudentSpringDataService;
import com.SSDM.server.AutowiringRemoteServiceServlet;
import com.SSDM.model.entityVO.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentServiceImpl extends AutowiringRemoteServiceServlet implements StudentService {

    @Autowired
    private transient StudentSpringDataService service;

    @Override
    public void add(StudentVO student) {
        service.addOrUpdate(student);
    }

    @Override
    public StudentVO getById(long id) {
        return service.getById(id);
    }

    @Override
    public List<StudentVO> getAll() {
        return service.getAll();
    }

    @Override
    public void delete(long id) {
        service.delete(id);
    }
}
