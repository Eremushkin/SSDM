package com.SSDM.client.ui.myWidget.listEntityFlexTable.impl;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Created by Daniil on 30.11.2016.
 */
public class TeacherListEntityFlexTable extends AbstractListEntityFlexTable<TeacherVO> {

    public static final String[] HEADER = {"Имя", "Предметы"};

    public TeacherListEntityFlexTable() {
        super(HEADER);
    }

    public TeacherListEntityFlexTable(DeleteStrategy<TeacherVO> deleteStrategy) {
        super(HEADER, deleteStrategy);
    }

    @Override
    public void initRow(int row, TeacherVO teacher) {
        String id = String.valueOf(teacher.getTeacherId());
        Hyperlink hyperlink = new Hyperlink(teacher.toString(), "Teacher" + id);

        FlexTable table = new FlexTable();
        for (int i = 0; i < teacher.getSubjects().size(); i++) {
            table.setText(i, 0, teacher.getSubjects().get(i).toString());
        }

        setWidget(row, 0, hyperlink);
        setWidget(row, 1, table);
    }
}
