package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.markService.MarkService;
import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.ui.myWidget.ListBoxCache;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.entityVO.StudentVO;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;


import java.util.Date;
import java.util.List;

/**
 * Created by Daniil on 07.12.2016.
 */
public class MarkAddPanel extends FlexTable {

    private static final String[] HEADER = {"Предмет", "Преподаватель", "Оценка", "Дата"};

    private StudentVO student;

    private ListBoxCache<SubjectVO> subjectListBox;
    private ListBoxCache<TeacherVO> teacherListBox;
    private ListBox markValue;
    private DateBox dateBox;
    private Button addButton;

    public MarkAddPanel(final StudentVO student) {
        this.student = student;

        subjectListBox = new ListBoxCache<>();
        teacherListBox = new ListBoxCache<>();
        markValue = new ListBox();
        dateBox = new DateBox();
        addButton = new Button("Добавить");

        SubjectService.App.getInstance().getAll(new AsyncCallback<List<SubjectVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<SubjectVO> subjectVOs) {
                subjectListBox.addAllObject(subjectVOs);
                if(subjectVOs != null){
                    teacherListBox.addAllObject(subjectVOs.get(0).getTeachers());
                }
            }
        });
        subjectListBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                teacherListBox.clear();
                SubjectVO subjectVO = subjectListBox.getSelectedObject();
                teacherListBox.addAllObject(subjectVO.getTeachers());
            }
        });


        for (int i = 0; i < 5; i++) {
            markValue.addItem(String.valueOf(i + 1));
        }

        for (int i = 0; i < HEADER.length; i++) {
            this.setText(i, 0, HEADER[i]);
        }


        dateBox.setValue(new Date());
        //dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT)));
        dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("d-M-y")));

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                MarkVO mark = new MarkVO();
                mark.setStudent(student);
                mark.setSubject(subjectListBox.getSelectedObject());
                mark.setTeacher(teacherListBox.getSelectedObject());
                mark.setMark(Integer.valueOf(markValue.getSelectedValue()));
                mark.setDate(dateBox.getValue());
                student.getMarks().add(mark);
                MarkService.App.getInstance().addOrUpdate(mark, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                });
            }
        });

        this.setWidget(0, 1, subjectListBox);
        this.setWidget(1, 1, teacherListBox);
        this.setWidget(2, 1, markValue);
        this.setWidget(3, 1, dateBox);
        this.setWidget(4, 1, addButton);
    }
}
