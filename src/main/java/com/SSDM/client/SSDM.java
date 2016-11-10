package com.SSDM.client;

import com.SSDM.client.ui.AddStudentPanel;
import com.SSDM.client.ui.StudentList;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class SSDM implements EntryPoint {

    @Override
    public void onModuleLoad() {


        RootPanel.get("slot1").add(new StudentList().init());

    }
}
