package com.SSDM.client.ui.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * Created by Daniil on 28.11.2016.
 */
public class StartPage extends HorizontalPanel {

    public StartPage() {
        Button showStudentListButton = new Button("Показать список студентов");
        showStudentListButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                History.newItem("studentList");
            }
        });

        Button showTeacherListButton = new Button("Показать список преподавателей");
        showTeacherListButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                History.newItem("teacherList");
            }
        });

        Button showSubjectListButton = new Button("Показать список предметов");
        showSubjectListButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                History.newItem("subjectList");
            }
        });

        add(showStudentListButton);
        add(showTeacherListButton);
        add(showSubjectListButton);
    }
}
