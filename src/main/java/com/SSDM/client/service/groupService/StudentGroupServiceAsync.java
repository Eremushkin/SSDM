package com.SSDM.client.service.groupService;


import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Daniil on 07.11.2016.
 */
public interface StudentGroupServiceAsync {
    //void addOrUpdate(StudentGroup studentGroup);

    void getAll(AsyncCallback<List<StudentGroupVO>> async);
    void getByGroupNumber(String number, AsyncCallback<StudentGroupVO> async);



}
