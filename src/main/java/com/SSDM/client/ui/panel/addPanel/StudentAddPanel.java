package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.entityVO.StudentVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import java.util.List;



public class StudentAddPanel {

    private static final String NAME_MESSAGE_ERROR = "может содержать только символы а-я, А-Я, a-z, A-Z";

    private static VerticalPanel initNameWidget(String name, Widget... widgets){
        Label label = new Label(name);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(label);
        for (Widget widget : widgets) {
            verticalPanel.add(widget);
        }
        return verticalPanel;
    }

    private static ListBox getListBox(){
        final ListBox groupListBox = new ListBox();
        StudentGroupService.App.getInstance().getAll(new AsyncCallback<List<StudentGroupVO>>() {

            @Override
            public void onFailure(Throwable throwable) {

            }
            @Override
            public void onSuccess(List<StudentGroupVO> studentGroupVOs) {
                for (StudentGroupVO group : studentGroupVOs) {
                    groupListBox.addItem(group.getGroupNumber());
                }
            }
        });
        return groupListBox;
    }

    private static boolean validateName(String text){
        RegExp regExp = RegExp.compile("[a-zA-Zа-яА-Я]{2,30}","g");

        MatchResult matchResult = regExp.exec(text);
        return matchResult != null && matchResult.getGroup(0).length() == text.length();
    }

    public static HorizontalPanel getAddStudentHorizontalPanel(){
        HorizontalPanel addStudentHorizontalPanel = new HorizontalPanel();
        addStudentHorizontalPanel.setWidth("50%");

        final TextBox firstNameTextBox = new TextBox();
        final Label firstNameErrorLabel = new Label();
        firstNameErrorLabel.setWidth("100%");
        firstNameErrorLabel.getElement().getStyle().setColor("red");

        final TextBox lastNameTextBox = new TextBox();
        final Label lastNameErrorLabel = new Label();
        lastNameErrorLabel.setWidth("100%");
        lastNameErrorLabel.getElement().getStyle().setColor("red");

        final ListBox groupListBox = getListBox();
        groupListBox.setPixelSize(50, 22);
        Label groupErrorLabel = new Label();

        final Button addButton = new Button("Добавить");
        addButton.setPixelSize(70, 36);
        addButton.setEnabled(false);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                StudentGroupService.App.getInstance().getByGroupNumber(groupListBox.getSelectedItemText(), new AsyncCallback<StudentGroupVO>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(StudentGroupVO studentGroupVO) {
                        StudentVO newStudentVO = new StudentVO();

                        newStudentVO.setFirstName(firstNameTextBox.getText());
                        newStudentVO.setLastName(lastNameTextBox.getText());
                        newStudentVO.setStudentGroup(studentGroupVO);

                        StudentService.App.getInstance().add(newStudentVO, new AsyncCallback<Void>() {
                            @Override
                            public void onFailure(Throwable throwable) {

                            }

                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        });
                    }
                });
            }
        });


        firstNameTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {

            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                if(validateName(firstNameTextBox.getText())){
                    firstNameErrorLabel.setText("");
                    if(validateName(lastNameTextBox.getText())){
                        addButton.setEnabled(true);
                    }

                } else {
                    firstNameErrorLabel.setText("Имя " + NAME_MESSAGE_ERROR);
                    addButton.setEnabled(false);
                }
            }
        });

        lastNameTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {

            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                if(validateName(lastNameTextBox.getText())){
                    lastNameErrorLabel.setText("");
                    if(validateName(firstNameTextBox.getText())){
                        addButton.setEnabled(true);
                    }
                } else {
                    lastNameErrorLabel.setText("Фамилия " + NAME_MESSAGE_ERROR);
                    addButton.setEnabled(false);
                }
            }
        });

        addStudentHorizontalPanel.add(initNameWidget("Фамилия", lastNameTextBox, lastNameErrorLabel));
        addStudentHorizontalPanel.add(initNameWidget("Имя", firstNameTextBox, firstNameErrorLabel));
        addStudentHorizontalPanel.add(initNameWidget("Группа", groupListBox, groupErrorLabel));
        addStudentHorizontalPanel.add(addButton);

        FileUpload fileUpload = new FileUpload();


        return addStudentHorizontalPanel;
    }


}
