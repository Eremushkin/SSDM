package com.SSDM.client.ui.panel.listPanel.impl;

import com.SSDM.client.ui.panel.listPanel.AbstractListPanel;
import com.SSDM.model.entityVO.SubjectVO;


public class SubjectListPanel extends AbstractListPanel<SubjectVO> {

    private static final String[] HEADER = {"Название предмета"};

    public SubjectListPanel() {
        super(new String[0]);
    }

    @Override
    protected void initRow(int row, SubjectVO subject) {
        this.setText(row, 0, subject.getSubjectName());
    }

}
