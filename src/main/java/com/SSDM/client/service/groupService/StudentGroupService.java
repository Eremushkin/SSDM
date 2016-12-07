package com.SSDM.client.service.groupService;


import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("StudentGroupService")
public interface StudentGroupService extends RemoteService {

    //void addOrUpdate(StudentGroup studentGroup);
    List<StudentGroupVO> getAll();
    StudentGroupVO getByGroupNumber(String number);


    public static class App {
        private static StudentGroupServiceAsync ourInstance = GWT.create(StudentGroupService.class);
        public static synchronized StudentGroupServiceAsync getInstance() {
            return ourInstance;
        }
    }

}
