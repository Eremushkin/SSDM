package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.ui.myWidget.ErrorLabel;
import com.SSDM.client.ui.myWidget.ListBoxCache;
import com.SSDM.client.ui.myWidget.ValidateTextBox;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.client.ui.panel.addPanel.validator.impl.NameValidator;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Created by Daniil on 09.12.2016.
 */
public class StudentAddPanel extends HorizontalPanel {

    private ValidateTextBox firstNameTextBox;
    private ValidateTextBox lastNameTextBox;
    private ErrorLabel firstNameErrorLabel;
    private ErrorLabel lastNameErrorLabel;
    private ListBoxCache<StudentGroupVO> studentGroupListBox;
    private Button addButton;


    private VerticalPanel initNameWidget(String name, Widget... widgets){
        Label label = new Label(name);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(label);
        for (Widget widget : widgets) {
            verticalPanel.add(widget);
        }
        return verticalPanel;
    }

    public StudentAddPanel(final UpdatingStrategy updatingStrategy) {

        firstNameTextBox = new ValidateTextBox(NameValidator.getValidator());
        lastNameTextBox = new ValidateTextBox(NameValidator.getValidator());

        firstNameErrorLabel = new ErrorLabel(NameValidator.getValidator().getErrorMessage("Имя"));
        firstNameErrorLabel.setWidth("100%");
        lastNameErrorLabel = new ErrorLabel(NameValidator.getValidator().getErrorMessage("Фамилия"));
        lastNameErrorLabel.setWidth("100%");

        studentGroupListBox = new ListBoxCache<>();
        addButton = new Button("Добавить");

        firstNameTextBox.addErrorLableChangeHandler(firstNameErrorLabel);
        lastNameTextBox.addErrorLableChangeHandler(lastNameErrorLabel);

        ValueChangeHandler<String> changeVisibleButton = new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                addButton.setEnabled(firstNameTextBox.isValidText()
                        && lastNameTextBox.isValidText());

            }
        };

        firstNameTextBox.addValueChangeHandler(changeVisibleButton);
        lastNameTextBox.addValueChangeHandler(changeVisibleButton);

        StudentGroupService.App.getInstance().getAll(new AsyncCallback<List<StudentGroupVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<StudentGroupVO> studentGroupVOs) {
                studentGroupListBox.addAllObject(studentGroupVOs);
            }
        });

        addButton.setPixelSize(70, 36);
        addButton.setEnabled(false);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                StudentVO newStudentVO = new StudentVO();

                newStudentVO.setFirstName(firstNameTextBox.getText());
                newStudentVO.setLastName(lastNameTextBox.getText());
                newStudentVO.setStudentGroup(studentGroupListBox.getSelectedObject());

                StudentService.App.getInstance().add(newStudentVO, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Запись успешно добавлена!");
                        firstNameTextBox.setText("");
                        lastNameTextBox.setText("");

                        updatingStrategy.update();
                    }

                });
            }
        });

        setWidth("50%");

        add(initNameWidget("Фимилия", lastNameTextBox, lastNameErrorLabel));
        add(initNameWidget("Имя", firstNameTextBox, firstNameErrorLabel));
        add(initNameWidget("Группа", studentGroupListBox));
        add(addButton);
    }

    public Button getAddButton() {
        return addButton;
    }
}
