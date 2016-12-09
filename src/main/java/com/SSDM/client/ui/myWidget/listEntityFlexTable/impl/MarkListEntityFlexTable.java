package com.SSDM.client.ui.myWidget.listEntityFlexTable.impl;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Hyperlink;


public class MarkListEntityFlexTable extends AbstractListEntityFlexTable<MarkVO> {
    private static final String[] HEADER = {"Предмет", "Преподаватель", "Оценка", "Дата"};

    public MarkListEntityFlexTable() {
        super(HEADER);
    }

    public MarkListEntityFlexTable(DeleteStrategy<MarkVO> deleteStrategy) {
        super(HEADER, deleteStrategy);
    }

    public void initRow(int row, MarkVO mark){
        //this.setText(row + 1, 0, mark.getStudent().toString());
        this.setText(row + 1, 0, mark.getSubject().toString());

        TeacherVO teacher = mark.getTeacher();
        String id = String.valueOf(teacher.getTeacherId());
        Hyperlink teacherHyperlink = new Hyperlink(teacher.toString(), "Teacher" + teacher.getTeacherId());
        this.setWidget(row + 1, 1, teacherHyperlink);

        this.setText(row + 1, 2, String.valueOf(mark.getMark()));

        DateLabel dateLabel = new DateLabel(DateTimeFormat.getFormat("d-M-y"));
        dateLabel.setValue(mark.getDate());
        this.setWidget(row + 1, 3, dateLabel);
    }
}
