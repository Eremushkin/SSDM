package com.SSDM.client.service.studentService;

import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Daniil on 07.11.2016.
 */
public interface StudentServiceAsync {


    void getAll(AsyncCallback<List<StudentVO>> async);

    void add(StudentVO student, AsyncCallback<Void> async);

    void getById(long id, AsyncCallback<StudentVO> async);

    void delete(long id, AsyncCallback<Void> async);
}
