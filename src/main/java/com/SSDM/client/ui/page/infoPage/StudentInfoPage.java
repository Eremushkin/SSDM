package com.SSDM.client.ui.page.infoPage;

import com.SSDM.client.ui.panel.listPanel.impl.MarkListPanel;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by Daniil on 28.11.2016.
 */
public class StudentInfoPage extends VerticalPanel{
    StudentVO student;
    MarkListPanel markListPanel;
    public StudentInfoPage(StudentVO student) {
        this.student = student;

        markListPanel = new MarkListPanel();
        markListPanel.init(student.getMarks());
        markListPanel.getRowFormatter().addStyleName(0, "entityListHeader");
        add(new HTML("<h1>" + this.student.toString() + "</h1>"));
        add(new HTML("<h2>" + this.student.getStudentGroup().getGroupNumber() + " группа </h2>" ));
        add(new HTML("<h4>Список оценок</h4>" ));
        add(markListPanel);
    }




}
