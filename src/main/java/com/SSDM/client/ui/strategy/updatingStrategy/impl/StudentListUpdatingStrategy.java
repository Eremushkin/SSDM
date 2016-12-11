package com.SSDM.client.ui.strategy.updatingStrategy.impl;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.StudentListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;

public class StudentListUpdatingStrategy implements UpdatingStrategy {

    private ListBox groupListBox;
    private AbstractListEntityFlexTable<StudentVO> abstractListEntityFlexTable;

    public StudentListUpdatingStrategy(ListBox groupListBox, StudentListEntityFlexTable abstractListEntityFlexTable) {
        this.groupListBox = groupListBox;
        this.abstractListEntityFlexTable = abstractListEntityFlexTable;
    }

    @Override
    public void update() {
        StudentGroupService.App.getInstance().getByGroupNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(StudentGroupVO studentGroupVO) {
                abstractListEntityFlexTable.init(studentGroupVO.getStudents());
            }
        });
    }
}
