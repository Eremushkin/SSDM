package com.SSDM.client.ui.strategy.updatingStrategy.impl;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public class TeacherListUpdatingStrategy implements UpdatingStrategy {

    private AbstractListEntityFlexTable<TeacherVO> abstractListEntityFlexTable;

    public TeacherListUpdatingStrategy(AbstractListEntityFlexTable<TeacherVO> abstractListEntityFlexTable) {
        this.abstractListEntityFlexTable = abstractListEntityFlexTable;
    }

    @Override
    public void update() {
        TeacherService.App.getInstance().getAll(new AsyncCallback<List<TeacherVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<TeacherVO> teacherVOs) {
                abstractListEntityFlexTable.init(teacherVOs);
            }
        });
    }
}
