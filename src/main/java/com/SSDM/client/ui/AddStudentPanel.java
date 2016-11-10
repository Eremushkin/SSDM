package com.SSDM.client.ui;

import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.model.entity.Student;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Daniil on 07.11.2016.
 */
public class AddStudentPanel {



    private VerticalPanel makeTextBoxAndLabelVertical(String name, TextBox textBox) {

        final Label label = new Label(name);
        final VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(label);
        verticalPanel.add(textBox);
        return verticalPanel;
    }
    public void init() {

        /*final Button show = new Button("Show all students");
        final Button addButton = new Button("Add");

        final TextBox firstNameTextBox = new TextBox();
        final TextBox secondNameTextBox = new TextBox();
        final Label label = new Label();
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                //StudentService.App.getInstance().add(new Student(firstNameTextBox.getText(), secondNameTextBox.getText()), new ListGroupAsyncCallback(label));
                //ssdmService.getMessage("Hello word", new ListGroupAsyncCallback(label));
            }
        });


        RootPanel.get("slot1").add(makeTextBoxAndLabelVertical("First name", firstNameTextBox));
        RootPanel.get("slot1").add(makeTextBoxAndLabelVertical("Second name", secondNameTextBox));
        RootPanel.get("slot1").add(addButton);
        RootPanel.get("slot1").add(label);*/


    }


}
