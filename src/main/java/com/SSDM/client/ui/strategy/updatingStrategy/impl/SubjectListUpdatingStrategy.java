package com.SSDM.client.ui.strategy.updatingStrategy.impl;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.SubjectVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Daniil on 11.12.2016.
 */
public class SubjectListUpdatingStrategy implements UpdatingStrategy {

    private AbstractListEntityFlexTable<SubjectVO> abstractListEntityFlexTable;

    public SubjectListUpdatingStrategy(AbstractListEntityFlexTable<SubjectVO> abstractListEntityFlexTable) {
        this.abstractListEntityFlexTable = abstractListEntityFlexTable;
    }

    @Override
    public void update() {
        SubjectService.App.getInstance().getAll(new AsyncCallback<List<SubjectVO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<SubjectVO> subjectVOs) {
                abstractListEntityFlexTable.init(subjectVOs);
            }
        });
    }
}
