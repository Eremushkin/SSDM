package com.SSDM.client.service.teacherService;

import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("TeacherService")
public interface TeacherService extends RemoteService {

    List<TeacherVO> getAll();
    void addOrUpdate(TeacherVO teacherVO);

    class App {

        private static TeacherServiceAsync ourInstance = GWT.create(TeacherService.class);

        public static synchronized TeacherServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
