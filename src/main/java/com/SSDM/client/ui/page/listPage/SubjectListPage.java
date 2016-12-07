package com.SSDM.client.ui.page.listPage;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.ui.panel.addPanel.SubjectAddPanel;
import com.SSDM.client.ui.panel.listPanel.impl.SubjectListPanel;
import com.SSDM.model.entityVO.SubjectVO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.List;

public class SubjectListPage extends VerticalPanel {

    private SubjectListPanel subjectListPanel;
    private SubjectAddPanel subjectAddPanel;

    public SubjectListPage() {

        subjectListPanel = new SubjectListPanel();
        subjectAddPanel = new SubjectAddPanel();


        SubjectService.App.getInstance().getAll(new AsyncCallback<List<SubjectVO>>() {
            @Override
            public void onFailure(Throwable throwable) {
                add(new Label("error"));
            }

            @Override
            public void onSuccess(List<SubjectVO> subjectVOs) {
                subjectListPanel.init(subjectVOs);
            }
        });

        add(new HTML("<h1>" + "Список предметов"  + "</h1>"));
        add(subjectListPanel);
        add(new HTML("<h4>" + "Добавить новый предмет"  + "</h4>"));
        add(subjectAddPanel);
    }
}
