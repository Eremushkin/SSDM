package com.SSDM.client.ui.page.listPage;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.ui.panel.addPanel.StudentAddPanel;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.StudentListEntityFlexTable;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;


public class StudentListPage extends VerticalPanel {

    private final StudentListEntityFlexTable studentListPanel = new StudentListEntityFlexTable();

    public StudentListPage() {
        final ListBox groupListBox = getListBox();
        final Label label = new Label();

        groupListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent changeEvent) {
                StudentGroupService.App.getInstance().getByGroupNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {

                    @Override
                    public void onFailure(Throwable throwable) {
                        label.setText(throwable.getMessage());
                    }
                    @Override
                    public void onSuccess(StudentGroupVO studentGroupVO) {
                        studentListPanel.clear();
                        studentListPanel.init(studentGroupVO.getStudents());
                    }
                });
            }
        });
        add(groupListBox);
        add(studentListPanel);
        add(StudentAddPanel.getAddStudentHorizontalPanel());
        add(label);

    }

    private ListBox getListBox(){
        final ListBox groupListBox = new ListBox();
        StudentGroupService.App.getInstance().getAll(new AsyncCallback<List<StudentGroupVO>>() {

            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<StudentGroupVO> studentGroupVOs) {
                for (StudentGroupVO group : studentGroupVOs) {
                    groupListBox.addItem(group.getGroupNumber());
                }
                if(studentGroupVOs != null){
                    studentListPanel.init(studentGroupVOs.get(0).getStudents());
                }
            }
        });
        return groupListBox;
    }


}
