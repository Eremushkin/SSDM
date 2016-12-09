package com.SSDM.client.ui.page.infoPage.widget;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.SubjectListEntityFlexTable;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

public class SubjectListDeleteButton extends SubjectListEntityFlexTable {

    TeacherVO teacherVO;

    public SubjectListDeleteButton(TeacherVO teacherVO) {
        super();
        this.teacherVO = teacherVO;
    }

    @Override
    public void initRow(final int row, final SubjectVO subject) {
        super.initRow(row, subject);
        Button deleteButton = new Button("X");
        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                teacherVO.getSubjects().remove(subject);
                TeacherService.App.getInstance().addOrUpdate(teacherVO, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Запесь удалена");
                    }
                });
                removeRow(row);
                init(teacherVO.getSubjects());
            }
        });
        setWidget(row, 1, deleteButton);
    }

}
