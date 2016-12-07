package com.SSDM.client.ui.panel.listPanel.impl;

import com.SSDM.client.ui.panel.listPanel.AbstractListPanel;
import com.SSDM.model.entityVO.MarkVO;


public class MarkListPanel extends AbstractListPanel<MarkVO> {
    private static final String[] HEADER = {"Студент", "Предмет", "Преподаватель", "Оценка", "Дата"};

    public MarkListPanel() {
        super(HEADER);
    }

    protected void initRow(int row, MarkVO mark){
        this.setText(row + 1, 0, mark.getStudent().toString());
        this.setText(row + 1, 1, mark.getSubject().toString());
        this.setText(row + 1, 2, mark.getTeacher().toString());
        this.setText(row + 1, 3, String.valueOf(mark.getMark()));
        this.setText(row + 1, 4, mark.getDate().toString());
    }
}
