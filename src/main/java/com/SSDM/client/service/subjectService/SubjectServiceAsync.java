package com.SSDM.client.service.subjectService;

import com.SSDM.model.entityVO.SubjectVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface SubjectServiceAsync {

    void getAll(AsyncCallback<List<SubjectVO>> async);

    void addOrUpdate(SubjectVO subjectVO, AsyncCallback<SubjectVO> async);
}
