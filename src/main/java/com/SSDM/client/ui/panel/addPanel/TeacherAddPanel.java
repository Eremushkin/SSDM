package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.checkBoxList.CheckBoxListCache;
import com.SSDM.client.ui.myWidget.ValidateTextBox;
import com.SSDM.client.ui.myWidget.ErrorLabel;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.client.ui.panel.addPanel.validator.impl.NameValidator;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class TeacherAddPanel extends VerticalPanel {

    private ValidateTextBox firstNameTextBox;
    private ValidateTextBox lastNameTextBox;
    private ValidateTextBox middleNameTextBox;
    private CheckBoxListCache<SubjectVO> checkBoxList;

    private FlexTable fullNameTable;
    private Button addButton;

    private void initColumn(FlexTable table, int column, Widget... widgets){
        for (int i = 0; i < widgets.length; i++) {
            table.setWidget(i, column, widgets[i]);
        }
    }

    public TeacherAddPanel(final UpdatingStrategy updatingStrategy) {
        fullNameTable= new FlexTable();
        checkBoxList = new CheckBoxListCache<>();

        firstNameTextBox = new ValidateTextBox(NameValidator.getValidator());
        lastNameTextBox = new ValidateTextBox(NameValidator.getValidator());
        middleNameTextBox = new ValidateTextBox(NameValidator.getValidator());

        SubjectService.App.getInstance().getAll(new AsyncCallback<List<SubjectVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<SubjectVO> subjectVOs) {
                checkBoxList.addAll(subjectVOs);
            }
        });

        addButton = new Button("Добавить");
        addButton.setEnabled(false);

        ErrorLabel firstNameErrorLabel = new ErrorLabel(NameValidator.getValidator().getErrorMessage("Имя"));
        ErrorLabel lastNameErrorLabel = new ErrorLabel(NameValidator.getValidator().getErrorMessage("Фамилия"));
        ErrorLabel middleNameErrorLabel = new ErrorLabel(NameValidator.getValidator().getErrorMessage("Отчество"));

        firstNameTextBox.addErrorLableChangeHandler(firstNameErrorLabel);
        lastNameTextBox.addErrorLableChangeHandler(lastNameErrorLabel);
        middleNameTextBox.addErrorLableChangeHandler(middleNameErrorLabel);

        initColumn(fullNameTable, 0, new Label("Фамилия"), new Label("Имя"), new Label("Отчество"), new Label("Предметы"));
        initColumn(fullNameTable, 1, lastNameTextBox, firstNameTextBox, middleNameTextBox);
        initColumn(fullNameTable, 2, lastNameErrorLabel, firstNameErrorLabel, middleNameErrorLabel);

        ValueChangeHandler<String> changeVisibleButton = new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                addButton.setEnabled(firstNameTextBox.isValidText()
                                        && lastNameTextBox.isValidText()
                                        && middleNameTextBox.isValidText());

            }
        };

        firstNameTextBox.addValueChangeHandler(changeVisibleButton);
        lastNameTextBox.addValueChangeHandler(changeVisibleButton);
        middleNameTextBox.addValueChangeHandler(changeVisibleButton);

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                String firstName = firstNameTextBox.getValue();
                String lastName = lastNameTextBox.getValue();
                String middleName = middleNameTextBox.getValue();
                TeacherVO newTeacher = new TeacherVO(firstName, lastName, middleName);
                newTeacher.setSubjects(checkBoxList.getSelectedObject());
                TeacherService.App.getInstance().addOrUpdate(newTeacher, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Записть успешно добавлена!");
                        firstNameTextBox.setText("");
                        lastNameTextBox.setText("");
                        middleNameTextBox.setText("");
                        updatingStrategy.update();
                    }
                });
            }
        });

        this.setHorizontalAlignment(ALIGN_RIGHT);

        add(fullNameTable);
        add(checkBoxList);
        add(addButton);
    }

    public Button getAddButton(){
        return addButton;
    }
}
