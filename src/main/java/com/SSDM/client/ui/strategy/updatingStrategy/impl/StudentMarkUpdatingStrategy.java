package com.SSDM.client.ui.strategy.updatingStrategy.impl;

import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Daniil on 11.12.2016.
 */
public class StudentMarkUpdatingStrategy implements UpdatingStrategy {

    private long studentId;
    private AbstractListEntityFlexTable<MarkVO> abstractListEntityFlexTable;


    public StudentMarkUpdatingStrategy(long studentId, AbstractListEntityFlexTable<MarkVO> abstractListEntityFlexTable) {
        this.studentId = studentId;
        this.abstractListEntityFlexTable = abstractListEntityFlexTable;
    }


    @Override
    public void update() {
        StudentService.App.getInstance().getById(studentId, new AsyncCallback<StudentVO>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(StudentVO studentVO) {
                abstractListEntityFlexTable.init(studentVO.getMarks());
            }
        });
    }
}
