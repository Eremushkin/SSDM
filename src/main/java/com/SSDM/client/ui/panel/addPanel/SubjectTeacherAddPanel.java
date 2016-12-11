package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.ListBoxCache;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;

/**
 * Created by Daniil on 11.12.2016.
 */
public class SubjectTeacherAddPanel extends VerticalPanel {

    ListBoxCache<SubjectVO> listBox;
    Button addButton;

    public SubjectTeacherAddPanel(final TeacherVO teacherVO, final UpdatingStrategy updatingStrategy) {

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
                        updatingStrategy.update();
                    }
                });
            }
        });

        add(listBox);
        add(addButton);
    }
}
