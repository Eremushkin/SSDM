package com.SSDM.client.ui.myWidget.listEntityFlexTable;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy.DeleteStrategy;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

import java.util.List;

public abstract class AbstractListEntityFlexTable<T> extends FlexTable {

    private final String[] header;
    private boolean showDeleteButton;
    private DeleteStrategy<T> deleteStrategy;

    protected AbstractListEntityFlexTable(String[] header) {
        this.header = header;
        showDeleteButton = false;
    }

    public AbstractListEntityFlexTable(String[] header, DeleteStrategy<T> deleteStrategy) {
        this.header = header;
        this.deleteStrategy = deleteStrategy;
        showDeleteButton = true;
    }

    public abstract void initRow(int row, T t);

    public void init(List<T> entityList){
        this.clear(true);

        for (int i = 0; i < header.length; i++) {
            this.setText(0, i, header[i]);
        }

        if(entityList != null) {
            for (int i = 0; i < entityList.size(); i++) {
                initRow(i + 1, entityList.get(i));
                if(showDeleteButton) {
                    addDeleteButton(i + 1, entityList.get(i));
                }
            }
        }
        this.getRowFormatter().addStyleName(0, "entityListHeader");
    }

    protected void addDeleteButton(final int row, final T t){
        Button deleteButton = new Button("X");

        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                removeRow(row);
                init(deleteStrategy.delete(t));
            }
        });
        setWidget(row, header.length, deleteButton);
    }




}
