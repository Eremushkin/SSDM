package com.SSDM.client.ui.strategy.updatingStrategy.impl;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Daniil on 11.12.2016.
 */
public class TeacherInfoUpdatingStrategy implements UpdatingStrategy {

    private long teacherId;
    private AbstractListEntityFlexTable<SubjectVO> abstractListEntityFlexTable;

    public TeacherInfoUpdatingStrategy(long teacherId, AbstractListEntityFlexTable<SubjectVO> abstractListEntityFlexTable) {
        this.teacherId = teacherId;
        this.abstractListEntityFlexTable = abstractListEntityFlexTable;
    }

    @Override
    public void update() {
        TeacherService.App.getInstance().getById(teacherId, new AsyncCallback<TeacherVO>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(TeacherVO teacherVO) {
                abstractListEntityFlexTable.init(teacherVO.getSubjects());
            }
        });
    }
}
