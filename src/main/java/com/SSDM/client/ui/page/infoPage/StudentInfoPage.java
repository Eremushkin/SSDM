package com.SSDM.client.ui.page.infoPage;

import com.SSDM.client.ui.strategy.deleteStrategy.impl.MarkDeleteStrategy;
import com.SSDM.client.ui.panel.addPanel.MarkAddPanel;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.MarkListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.impl.StudentMarkUpdatingStrategy;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by Daniil on 28.11.2016.
 */
public class StudentInfoPage extends VerticalPanel{
    StudentVO student;
    MarkListEntityFlexTable markListPanel;
    MarkAddPanel markAddPanel;
    public StudentInfoPage(StudentVO student) {
        this.student = student;

        markListPanel = new MarkListEntityFlexTable(new MarkDeleteStrategy(student.getStudentId()));
        markListPanel.init(student.getMarks());
        markListPanel.getRowFormatter().addStyleName(0, "entityListHeader");



        markAddPanel = new MarkAddPanel(student, new StudentMarkUpdatingStrategy(student.getStudentId(), markListPanel));



        add(new HTML("<h1>" + this.student.toString() + "</h1>"));
        add(new HTML("<h2>" + this.student.getStudentGroup().getGroupNumber() + " группа </h2>" ));
        add(new HTML("<h3>Список оценок</h3>" ));
        add(markListPanel);
        add(new HTML("<h3> Добавить новую оценку </h3>" ));
        add(markAddPanel);
    }




}
