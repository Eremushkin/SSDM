package com.SSDM.client.ui.page.listPage;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.ui.myWidget.ListBoxCache;
import com.SSDM.client.ui.strategy.deleteStrategy.impl.StudentDeleteStrategy;
import com.SSDM.client.ui.panel.addPanel.StudentAddPanel;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.StudentListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.impl.StudentListUpdatingStrategy;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;


public class StudentListPage extends VerticalPanel {

    private ListBoxCache<StudentGroupVO> groupListBox;
    private StudentListEntityFlexTable studentListPanel;
    private StudentAddPanel studentAddPanel;

    public StudentListPage() {

        groupListBox = new ListBoxCache<>();
        studentListPanel = new StudentListEntityFlexTable(new StudentDeleteStrategy(groupListBox));
        studentAddPanel = new StudentAddPanel(new StudentListUpdatingStrategy(groupListBox, studentListPanel));

        StudentGroupService.App.getInstance().getAll(new AsyncCallback<List<StudentGroupVO>>() {

            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("ups");
            }
            @Override
            public void onSuccess(List<StudentGroupVO> studentGroupVOs) {
                groupListBox.addAllObject(studentGroupVOs);
                if(studentGroupVOs != null){
                    studentListPanel.init(studentGroupVOs.get(0).getStudents());
                }
            }
        });

        groupListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent changeEvent) {
                StudentGroupService.App.getInstance().getByGroupNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(StudentGroupVO studentGroupVO) {
                        studentListPanel.init(studentGroupVO.getStudents());
                    }
                });

            }
        });

        add(new HTML("<h1>" + "Список студентов"  + "</h1>"));
        add(groupListBox);
        add(studentListPanel);
        add(new HTML("<h4>" + "Добавить нового студента"  + "</h4>"));
        add(studentAddPanel);
    }
}
