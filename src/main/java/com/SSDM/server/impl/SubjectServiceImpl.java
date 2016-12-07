package com.SSDM.server.impl;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.controler.service.SubjectSpringDataService;
import com.SSDM.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectServiceImpl extends AutowiringRemoteServiceServlet implements SubjectService{

    @Autowired
    private transient SubjectSpringDataService service;

    @Override
    public List<SubjectVO> getAll() {
        return service.getAll();
    }

    @Override
    public SubjectVO addOrUpdate(SubjectVO subjectVO) {
        return  service.addOrUpdate(subjectVO);
    }
}
