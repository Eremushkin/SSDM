package com.SSDM.client.ui.page.infoPage;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.impl.DeleteStrategyTeacherInfo;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.SubjectListEntityFlexTable;
import com.SSDM.client.ui.myWidget.ListBoxCache;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;


public class TeacherInfoPage extends VerticalPanel {

    TeacherVO teacher;
    SubjectListEntityFlexTable subjectListEntityFlexTable;
    ListBoxCache<SubjectVO> listBox;
    Button addButton;

    public TeacherInfoPage(final TeacherVO teacherVO) {
        this.teacher = teacherVO;

        subjectListEntityFlexTable = new SubjectListEntityFlexTable(new DeleteStrategyTeacherInfo(teacherVO));
        subjectListEntityFlexTable.init(teacher.getSubjects());

        listBox = new ListBoxCache<>();
        SubjectService.App.getInstance().getAll(new AsyncCallback<List<SubjectVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<SubjectVO> subjectVOs) {
                listBox.addAllObject(subjectVOs);
            }
        });
        addButton = new Button("Добавить");
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                SubjectVO subjectVO = listBox.getSelectedObject();
                teacherVO.getSubjects().add(subjectVO);
                TeacherService.App.getInstance().addOrUpdate(teacherVO, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Предмет добавлен");
                    }
                });
                subjectListEntityFlexTable.init(teacherVO.getSubjects());
            }
        });
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(listBox);
        verticalPanel.add(addButton);

        add(new HTML("<h1>" + teacher.toString() + "</h1>"));
        add(new HTML("<h3>Список предметов</h3>" ));
        add(subjectListEntityFlexTable);
        add(new HTML("<h3>Добавить предмет</h3>" ));
        add(verticalPanel);

    }
}
