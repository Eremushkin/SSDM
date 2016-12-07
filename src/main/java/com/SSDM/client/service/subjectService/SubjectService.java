package com.SSDM.client.service.subjectService;

import com.SSDM.model.entityVO.SubjectVO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("SubjectService")
public interface SubjectService extends RemoteService {

    List<SubjectVO> getAll();
    SubjectVO addOrUpdate(SubjectVO subjectVO);

    public static class App {

        private static SubjectServiceAsync ourInstance = GWT.create(SubjectService.class);

        public static synchronized  SubjectServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
