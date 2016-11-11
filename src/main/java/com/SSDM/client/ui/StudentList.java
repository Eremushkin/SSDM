package com.SSDM.client.ui;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;


public class StudentList extends VerticalPanel {

    private static final String[] STUDENT_LIST_HEADER = {"Фамилия", "Имя", "Номер группы"};
    private final FlexTable studentListFlexTable = new FlexTable();
    public VerticalPanel init(){
        final ListBox groupListBox = getListBox();


        final Label label = new Label();
        groupListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent changeEvent) {
                StudentGroupService.App.getInstance().getByNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        label.setText(throwable.getMessage());
                    }
                    @Override
                    public void onSuccess(StudentGroupVO studentGroupVO) {
                        initStudentListFlexTable(studentGroupVO);
                    }
                });
            }
        });

        add(groupListBox);
        add(studentListFlexTable);
        add(label);
        return this;
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
                    initStudentListFlexTable(studentGroupVOs.get(0));
                }
            }
        });
        return groupListBox;
    }

    private void initStudentListFlexTable(StudentGroupVO studentGroupVO) {
        studentListFlexTable.clear(true);

        for (int i = 0; i < STUDENT_LIST_HEADER.length; i++) {
            studentListFlexTable.setText(0, i, STUDENT_LIST_HEADER[i]);
        }
        studentListFlexTable.getRowFormatter().addStyleName(0, "studentListHeader");
        if(studentGroupVO.getStudents() != null) {
            for (int i = 0; i < studentGroupVO.getStudents().size(); i++) {
                studentListFlexTable.setText(i + 1, 0, studentGroupVO.getStudents().get(i).getFirstName());
                studentListFlexTable.setText(i + 1, 1, studentGroupVO.getStudents().get(i).getLastName());
                studentListFlexTable.setWidget(i + 1, 2, getHyperlink(studentGroupVO.getGroupNumber()));
            }
        }
    }

    private Hyperlink getHyperlink(String name){
        return new Hyperlink(name, "group" + name);
    }


}
