package com.SSDM.client.ui.myWidget.listEntityFlexTable.impl;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.ui.Hyperlink;


public class StudentListEntityFlexTable extends AbstractListEntityFlexTable<StudentVO> {

    private static final String[] HEADER = {"Фамилия Имя", "Номер группы"};

    public StudentListEntityFlexTable() {
        super(HEADER);
    }

    public StudentListEntityFlexTable(DeleteStrategy<StudentVO> deleteStrategy) {
        super(HEADER, deleteStrategy);
    }

    @Override
    public void initRow(final int row, final StudentVO studentVO) {
        String lastName = studentVO.getLastName();
        String firstName = studentVO.getFirstName();
        String groupNumber = studentVO.getStudentGroup().getGroupNumber();

        Hyperlink studentHyperlink
                = new Hyperlink(lastName + " " + firstName, "Student" + studentVO.getStudentId());

        this.setWidget(row, 0, studentHyperlink);
        this.setText(row, 1, groupNumber);
    }
}
