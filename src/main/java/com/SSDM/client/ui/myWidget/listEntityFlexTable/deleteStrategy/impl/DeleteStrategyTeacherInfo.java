package com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.impl;

import com.SSDM.client.service.teacherService.TeacherService;
import com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.DeleteStrategy;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.entityVO.TeacherVO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Daniil on 09.12.2016.
 */
public class DeleteStrategyTeacherInfo implements DeleteStrategy<SubjectVO> {

    private TeacherVO teacherVO;

    public DeleteStrategyTeacherInfo(TeacherVO teacherVO) {
        this.teacherVO = teacherVO;
    }

    @Override
    public List<SubjectVO> delete(SubjectVO subjectVO) {
        teacherVO.getSubjects().remove(subjectVO);
        TeacherService.App.getInstance().addOrUpdate(teacherVO, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Что-то пошло не так :(");
            }

            @Override
            public void onSuccess(Void aVoid) {
                Window.alert("Запись успешно удалена");
            }
        });
        return teacherVO.getSubjects();
    }
}
