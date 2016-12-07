package com.SSDM.client.ui.panel.listPanel.impl;

import com.SSDM.client.ui.panel.listPanel.AbstractListPanel;
import com.SSDM.model.entity.Teacher;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Created by Daniil on 30.11.2016.
 */
public class TeacherListPanel extends AbstractListPanel<TeacherVO> {

    public static final String[] HEADER = {"Имя", "Предметы"};

    public TeacherListPanel() {
        super(HEADER);
    }

    @Override
    protected void initRow(int row, TeacherVO teacher) {
        String id = String.valueOf(teacher.getTeacherId());
        Hyperlink hyperlink = new Hyperlink(teacher.toString(), "teacher" + id);
        FlexTable table = new FlexTable();
        for (int i = 0; i < teacher.getSubjects().size(); i++) {
            table.setText(i, 0, teacher.getSubjects().get(i).toString());
        }

        setWidget(row, 0, hyperlink);
        setWidget(row, 1, table);
    }
}
