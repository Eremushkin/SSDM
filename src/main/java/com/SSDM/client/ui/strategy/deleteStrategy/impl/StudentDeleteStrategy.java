package com.SSDM.client.ui.strategy.deleteStrategy.impl;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;

import java.util.ArrayList;


public class StudentDeleteStrategy implements DeleteStrategy<StudentVO> {
    ListBox listBox;

    public StudentDeleteStrategy(ListBox listBox) {
        this.listBox = listBox;
    }

    @Override
    public void delete(final AbstractListEntityFlexTable<StudentVO> abstractListEntityFlexTable, final StudentVO studentVO) {
        studentVO.setMarks(new ArrayList<MarkVO>());

        StudentService.App.getInstance().add(studentVO, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(Void aVoid) {
                StudentService.App.getInstance().delete(studentVO.getStudentId(), new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Запись успешно удалена!");

                        StudentGroupService.App.getInstance().getByGroupNumber(listBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
                            @Override
                            public void onFailure(Throwable throwable) {

                            }

                            @Override
                            public void onSuccess(StudentGroupVO studentGroupVO) {
                                abstractListEntityFlexTable.init(studentGroupVO.getStudents());
                            }
                        });
                    }
                });
            }
        });





    }
}
