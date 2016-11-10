/*package com.SSDM.client.ui;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.model.entity.StudentGroup;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;


public class StudentList extends VerticalPanel {

    private static final String[] STUDENT_LIST_HEADER = {"Фамилия", "Имя", "Номер группы"};

    public VerticalPanel init(){
        final ListBox groupListBox = getListBox();
        final FlexTable studentListFlexTable = new FlexTable();
       groupListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                StudentGroupService.App.getInstance().getByNumber(groupListBox.getSelectedItemText(),
                        new AsyncCallback<StudentGroup>() {
                            @Override
                            public void onFailure(Throwable throwable) {

                            }

                            @Override
                            public void onSuccess(StudentGroup studentGroup) {
                                initStudentList( studentListFlexTable, studentGroup);
                            }
                        });
            }
        });

        add(groupListBox);
        //add(studentListFlexTable);
        return this;
    }

    private ListBox getListBox(){
        ListBox groupListBox = new ListBox();
        StudentGroupService.App.getInstance().getAll(new ListGroupAsyncCallback(groupListBox));
        return groupListBox;
    }

    private void initStudentList(FlexTable studentListFlexTable, StudentGroup studentGroup){
        studentListFlexTable.clear();

        for (int i = 0; i < STUDENT_LIST_HEADER.length; i++) {
            studentListFlexTable.setText(0, i, STUDENT_LIST_HEADER[i]);
        }
        studentListFlexTable.getRowFormatter().addStyleName(0, "studentListHeader");
        if(studentGroup.getStudents() != null) {
            for (int i = 0; i < studentGroup.getStudents().size(); i++) {
                studentListFlexTable.setText(i + 1, 0, studentGroup.getStudents().get(i).getFirstName());
                studentListFlexTable.setText(i + 1, 1, studentGroup.getStudents().get(i).getLastName());
                studentListFlexTable.setText(i + 1, 2, studentGroup.getGroupNumber());
            }
        }
    }

    private static class ListGroupAsyncCallback implements AsyncCallback<List<StudentGroup>> {
        ListBox listBox;

        public ListGroupAsyncCallback(ListBox listBox) {
            this.listBox = listBox;
        }

        @Override
        public void onFailure(Throwable throwable) {

        }

        @Override
        public void onSuccess(List<StudentGroup> studentGroups) {
            for (StudentGroup studentGroup : studentGroups) {
                listBox.addItem(studentGroup.getGroupNumber());
            }

        }
    }

}
*/

package com.SSDM.client.ui;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;


public class StudentList extends VerticalPanel {

    private static final String[] STUDENT_LIST_HEADER = {"Фамилия", "Имя", "Номер группы"};

    public VerticalPanel init(){
        final ListBox groupListBox = getListBox();
        final FlexTable studentListFlexTable = new FlexTable();
        final Label label = new Label();
        groupListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                StudentGroupService.App.getInstance().getByNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        label.setText(throwable.getMessage());
                    }
                    @Override
                    public void onSuccess(StudentGroupVO studentGroupVO) {
                        initStudentListFlexTable(studentGroupVO, studentListFlexTable);
                    }
                });
            }
        });



        /*if(groupListBox.getElement().){
            StudentGroupService.App.getInstance().getByNumber(groupListBox.getItemText(0), new AsyncCallback<StudentGroupVO>() {
                @Override
                public void onFailure(Throwable throwable) {
                    label.setText(throwable.getMessage());
                }
                @Override
                public void onSuccess(StudentGroupVO studentGroupVO) {
                    initStudentListFlexTable(studentGroupVO, studentListFlexTable);
                }
            });
        }*/
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
            }
        });
        return groupListBox;
    }

    private void initStudentListFlexTable(StudentGroupVO studentGroupVO, FlexTable studentListFlexTable) {
        studentListFlexTable.clear(true);

        for (int i = 0; i < STUDENT_LIST_HEADER.length; i++) {
            studentListFlexTable.setText(0, i, STUDENT_LIST_HEADER[i]);
        }
        studentListFlexTable.getRowFormatter().addStyleName(0, "studentListHeader");
        if(studentGroupVO.getStudents() != null) {
            for (int i = 0; i < studentGroupVO.getStudents().size(); i++) {
                studentListFlexTable.setText(i + 1, 0, studentGroupVO.getStudents().get(i).getFirstName());
                studentListFlexTable.setText(i + 1, 1, studentGroupVO.getStudents().get(i).getLastName());
                studentListFlexTable.setText(i + 1, 2, studentGroupVO.getGroupNumber());
            }
        }
    }


}
