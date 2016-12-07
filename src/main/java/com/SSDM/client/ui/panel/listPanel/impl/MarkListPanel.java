package com.SSDM.client.ui.panel.listPanel.impl;

import com.SSDM.client.ui.panel.listPanel.AbstractListPanel;
import com.SSDM.model.entityVO.MarkVO;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DateBox;


public class MarkListPanel extends AbstractListPanel<MarkVO> {
    private static final String[] HEADER = {"Предмет", "Преподаватель", "Оценка", "Дата"};

    public MarkListPanel() {
        super(HEADER);
    }

    protected void initRow(int row, MarkVO mark){
        //this.setText(row + 1, 0, mark.getStudent().toString());
        this.setText(row + 1, 0, mark.getSubject().toString());
        this.setText(row + 1, 1, mark.getTeacher().toString());
        this.setText(row + 1, 2, String.valueOf(mark.getMark()));

        DateLabel dateLabel = new DateLabel(DateTimeFormat.getFormat("d-M-y"));
        dateLabel.setValue(mark.getDate());
        this.setWidget(row + 1, 3, dateLabel);
    }
}
