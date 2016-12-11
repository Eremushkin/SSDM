package com.SSDM.client.ui.panel.addPanel;

import com.SSDM.client.service.subjectService.SubjectService;
import com.SSDM.client.ui.strategy.updatingStrategy.UpdatingStrategy;
import com.SSDM.model.entityVO.SubjectVO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class SubjectAddPanel extends VerticalPanel{

    private TextBox subjectNameTextBox;
    private Button addButton;

    public SubjectAddPanel(final UpdatingStrategy updatingStrategy) {

        subjectNameTextBox = new TextBox();

        addButton = new Button("Добавить");
        addButton.setEnabled(false);


        subjectNameTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                addButton.setEnabled(subjectNameTextBox.getValue() != null && subjectNameTextBox.getValue().length() > 2);
            }
        });

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                SubjectService.App.getInstance().addOrUpdate(new SubjectVO(subjectNameTextBox.getValue()), new AsyncCallback<SubjectVO>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Что-то пошло не так :(");
                    }

                    @Override
                    public void onSuccess(SubjectVO subjectVO) {
                        Window.alert("Запись успешно добавлена!");
                        updatingStrategy.update();
                    }
                });
            }
        });

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(subjectNameTextBox);
        horizontalPanel.add(addButton);

        this.add(new Label("Название предмета"));
        this.add(horizontalPanel);

    }
}
