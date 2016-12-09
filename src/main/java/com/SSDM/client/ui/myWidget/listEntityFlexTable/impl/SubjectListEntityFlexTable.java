package com.SSDM.client.ui.myWidget.listEntityFlexTable.impl;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.SubjectVO;


public class SubjectListEntityFlexTable extends AbstractListEntityFlexTable<SubjectVO> {

    protected static final String[] HEADER = {"Название предмета"};

    public SubjectListEntityFlexTable() {
        super(HEADER);
    }

    public SubjectListEntityFlexTable(DeleteStrategy<SubjectVO> deleteStrategy) {
        super(HEADER, deleteStrategy);
    }

    @Override
    public void initRow(int row, SubjectVO subject) {
        this.setText(row, 0, subject.getSubjectName());
    }

}
