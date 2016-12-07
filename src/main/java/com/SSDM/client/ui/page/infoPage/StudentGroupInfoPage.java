package com.SSDM.client.ui.page.infoPage;

import com.SSDM.model.entityVO.StudentGroupVO;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by Daniil on 11.11.2016.
 */
public class StudentGroupInfoPage extends VerticalPanel {

    final StudentGroupVO group;

    public StudentGroupInfoPage(StudentGroupVO group) {
        this.group = group;
    }

    public VerticalPanel init(){

        add(new HTML("<h1>" + "Группа " + group.getGroupNumber() + "</h1>"));

        return this;
    }
}
