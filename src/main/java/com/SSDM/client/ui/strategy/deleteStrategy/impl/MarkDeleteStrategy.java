package com.SSDM.client.ui.strategy.deleteStrategy.impl;

import com.SSDM.client.service.markService.MarkService;
import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Daniil on 11.12.2016.
 */
public class MarkDeleteStrategy implements DeleteStrategy<MarkVO> {

    private long studentId;

    public MarkDeleteStrategy(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public void delete(final AbstractListEntityFlexTable<MarkVO> abstractListEntityFlexTable, final MarkVO markVO) {
        markVO.setTeacher(null);
        markVO.setSubject(null);
        markVO.setStudent(null);
        MarkService.App.getInstance().addOrUpdate(markVO, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("dasljhdfjklas");
            }

            @Override
            public void onSuccess(Void aVoid) {
                MarkService.App.getInstance().delete(markVO.getMarkId(), new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Запись успешно удалена!");
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
                });
            }
        });


    }
}
