package com.SSDM.client.service.teacherService;

import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface TeacherServiceAsync {

    void getAll(AsyncCallback<List<TeacherVO>> async);

    void addOrUpdate(TeacherVO teacherVO, AsyncCallback<Void> async);
}
