package com.SSDM.client.ui.page.infoPage;

import com.SSDM.client.ui.panel.addPanel.MarkAddPanel;
import com.SSDM.client.ui.panel.listPanel.impl.MarkListPanel;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.user.client.rpc.core.java.util.Collections;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

/**
 * Created by Daniil on 28.11.2016.
 */
public class StudentInfoPage extends VerticalPanel{
    StudentVO student;
    MarkListPanel markListPanel;
    MarkAddPanel markAddPanel;
    public StudentInfoPage(StudentVO student) {
        this.student = student;

        markListPanel = new MarkListPanel();
        markListPanel.init(student.getMarks());
        markListPanel.getRowFormatter().addStyleName(0, "entityListHeader");

        markAddPanel = new MarkAddPanel(student);

        add(new HTML("<h1>" + this.student.toString() + "</h1>"));
        add(new HTML("<h2>" + this.student.getStudentGroup().getGroupNumber() + " группа </h2>" ));
        add(new HTML("<h3>Список оценок</h3>" ));
        add(markListPanel);
        add(new HTML("<h3> Добавить новую оценку </h3>" ));
        add(markAddPanel);
    }




}
