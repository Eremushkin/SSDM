package com.SSDM.client.service.studentService;

import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Daniil on 07.11.2016.
 */
public interface StudentServiceAsync {

    //void add(Student student, AsyncCallback<Void> async);
    void getAll(AsyncCallback<List<StudentVO>> async);
}
