package com.SSDM.server.impl;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.controler.service.TeacherSpringDataService;
import com.SSDM.model.entityVO.TeacherVO;
import com.SSDM.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherServiceImpl extends AutowiringRemoteServiceServlet implements TeacherService{

    @Autowired
    private transient TeacherSpringDataService service;

    @Override
    public List<TeacherVO> getAll() {
        return service.getAll();
    }

    @Override
    public void addOrUpdate(TeacherVO teacherVO) {
        service.addOrUpdate(teacherVO);
    }
}
