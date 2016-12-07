package com.SSDM.server.impl;

import com.SSDM.client.service.markService.MarkService;
import com.SSDM.controler.service.MarkSpringDataService;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarkServiceImpl extends AutowiringRemoteServiceServlet implements MarkService{

    @Autowired
    private transient MarkSpringDataService service;

    @Override
    public void addOrUpdate(MarkVO markVO) {
        service.addOrUpdate(markVO);
    }
}
