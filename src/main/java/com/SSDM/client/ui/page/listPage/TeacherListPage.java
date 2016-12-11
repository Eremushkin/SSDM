package com.SSDM.client.ui.page.listPage;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.panel.addPanel.TeacherAddPanel;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.TeacherListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.impl.TeacherListUpdatingStrategy;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;


public class TeacherListPage extends VerticalPanel {

    protected TeacherListEntityFlexTable teacherListPanel;
    protected TeacherAddPanel teacherAddPanel;

    public TeacherListPage() {
        teacherListPanel = new TeacherListEntityFlexTable();
        teacherAddPanel = new TeacherAddPanel(new TeacherListUpdatingStrategy(teacherListPanel));


        TeacherService.App.getInstance().getAll(new AsyncCallback<List<TeacherVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<TeacherVO> teacherVOs) {
                teacherListPanel.init(teacherVOs);
            }
        });

        add(new HTML("<h1>" + "Список преподавателей"  + "</h1>"));
        add(teacherListPanel);
        add(teacherAddPanel);
    }

}
