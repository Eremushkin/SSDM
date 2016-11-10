package com.SSDM.client.service.studentService;

import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;


@RemoteServiceRelativePath("StudentService")
public interface StudentService extends RemoteService {

    //void add(Student student);
    List<StudentVO> getAll();

    public static class App {

        private static StudentServiceAsync ourInstance = GWT.create(StudentService.class);

        public static synchronized StudentServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
