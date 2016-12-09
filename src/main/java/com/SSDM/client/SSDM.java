package com.SSDM.client;

import com.SSDM.client.service.studentService.StudentService;
import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.page.StartPage;
import com.SSDM.client.ui.page.infoPage.StudentInfoPage;
import com.SSDM.client.ui.page.infoPage.TeacherInfoPage;
import com.SSDM.client.ui.page.listPage.StudentListPage;
import com.SSDM.client.ui.page.listPage.SubjectListPage;
import com.SSDM.client.ui.page.listPage.TeacherListPage;
import com.SSDM.model.entityVO.StudentVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class SSDM implements EntryPoint {

    @Override
    public void onModuleLoad() {

        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                String historyToken = valueChangeEvent.getValue();

                if ("Teacher".equals(historyToken.substring(0, 7))) {
                    clearRootPanel();
                    long id = Long.parseLong(historyToken.substring(7));
                    TeacherService.App.getInstance().getById(id, new AsyncCallback<TeacherVO>() {
                        @Override
                        public void onFailure(Throwable throwable) {

                        }

                        @Override
                        public void onSuccess(TeacherVO teacherVO) {
                            RootPanel.get("slot1").add(new TeacherInfoPage(teacherVO));
                        }
                    });
                } else if ("studentList".equals(historyToken)) {
                    clearRootPanel();
                    RootPanel.get("slot1").add(new StudentListPage());
                } else if ("teacherList".equals(historyToken)) {
                    clearRootPanel();
                    RootPanel.get("slot1").add(new TeacherListPage());
                } if ("subjectList".equals(historyToken)) {
                    clearRootPanel();
                    RootPanel.get("slot1").add(new SubjectListPage());
                } else if ("startPage".equals(historyToken)) {
                    clearRootPanel();
                    RootPanel.get("slot1").add(new StartPage());
                } else if ("Student".equals(historyToken.substring(0, 7))) {
                    clearRootPanel();
                    long id = Long.parseLong(historyToken.substring(7));
                    StudentService.App.getInstance().getById(id, new AsyncCallback<StudentVO>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                        }

                        @Override
                        public void onSuccess(StudentVO studentVO) {
                            RootPanel.get("slot1").add(new StudentInfoPage(studentVO));
                        }
                    });
                }
            }
        });
        Button button = new Button("button");
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            button.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    RootPanel.get("slot1").add(new Label("car: " + finalI));
                }
            });
        }

        History.newItem("startPage");
    }

    private void clearRootPanel(){
        if(RootPanel.get("slot1") != null){
            for (Widget widget : RootPanel.get("slot1")) {
                RootPanel.get("slot1").remove(widget);
            }
        }
    }
}
