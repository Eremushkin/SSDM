package com.SSDM.client.ui.page.infoPage;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.impl.SubjectListEntityFlexTable;
import com.SSDM.client.ui.panel.addPanel.SubjectTeacherAddPanel;
import com.SSDM.client.ui.strategy.updatingStrategy.impl.TeacherInfoUpdatingStrategy;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TeacherInfoPage extends VerticalPanel {

    TeacherVO teacher;
    SubjectListEntityFlexTable subjectListEntityFlexTable;
    SubjectTeacherAddPanel addPanel;

    public TeacherInfoPage(final TeacherVO teacherVO) {
        this.teacher = teacherVO;

        subjectListEntityFlexTable = new SubjectListEntityFlexTable();
        subjectListEntityFlexTable.init(teacher.getSubjects());

        addPanel = new SubjectTeacherAddPanel(teacherVO,
                            new TeacherInfoUpdatingStrategy(teacherVO.getTeacherId(), subjectListEntityFlexTable));

        add(new HTML("<h1>" + teacher.toString() + "</h1>"));
        add(new HTML("<h3>Список предметов</h3>" ));
        add(subjectListEntityFlexTable);
        add(new HTML("<h3>Добавить предмет</h3>" ));
        add(addPanel);

    }
}
