package com.SSDM.client.ui.panel.listPanel.impl;

import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.ui.panel.listPanel.AbstractListPanel;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


public class StudentListPanel extends AbstractListPanel<StudentVO> {
    private static final String[] HEADER = {"Фамилия Имя", "Номер группы"};


    public StudentListPanel() {
        super(HEADER);
    }

    @Override
    protected void initRow(final int row, final StudentVO studentVO) {
        String lastName = studentVO.getLastName();
        String firstName = studentVO.getFirstName();
        String groupNumber = studentVO.getStudentGroup().getGroupNumber();

        Hyperlink studentHyperlink
                = new Hyperlink(lastName + " " + firstName, "Student" + studentVO.getStudentId());
        Hyperlink groupHyperlink
                = new Hyperlink(groupNumber, "group" + groupNumber);

        Button deleteButton = new Button("X");
        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                StudentService.App.getInstance().delete(studentVO.getStudentId(), new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        RootPanel.get().add(new Label("dasdasdff"));
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        removeRow(row);
                    }
                });
            }
        });
        this.setWidget(row, 0, studentHyperlink);
        this.setWidget(row, 1, groupHyperlink);
        this.setWidget(row, 2, deleteButton);
    }
}
