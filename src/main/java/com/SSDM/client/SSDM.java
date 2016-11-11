package com.SSDM.client;

import com.SSDM.client.service.groupService.StudentGroupService;
import com.SSDM.client.ui.AddStudentPanel;
import com.SSDM.client.ui.StudentGroupInfo;
import com.SSDM.client.ui.StudentList;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer;
import com.google.gwt.user.client.ui.*;

public class SSDM implements EntryPoint {

    @Override
    public void onModuleLoad() {

        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                String historyToken = valueChangeEvent.getValue();
                if("group".equals(historyToken.substring(0, 5))){
                    StudentGroupService.App.getInstance().getByNumber(historyToken.substring(5), new AsyncCallback<StudentGroupVO>() {
                        @Override
                        public void onFailure(Throwable throwable) {

                        }

                        @Override
                        public void onSuccess(StudentGroupVO studentGroupVO) {
                            clearRootPanel();
                            RootPanel.get("slot1").add(new StudentGroupInfo(studentGroupVO).init());
                        }
                    });
                } else if("studentList".equals(historyToken)){
                    clearRootPanel();
                    RootPanel.get("slot1").add(new StudentList().init());
                }
            }
        });

        History.newItem("studentList");
    }

    private void clearRootPanel(){
        if(RootPanel.get("slot1") != null){
            for (Widget widget : RootPanel.get("slot1")) {
                RootPanel.get("slot1").remove(widget);
            }
        }
    }
}
