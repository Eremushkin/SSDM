package com.SSDM.client.ui.panel.listPanel;

import com.google.gwt.user.client.ui.FlexTable;

import java.util.List;

public abstract class AbstractListPanel<T> extends FlexTable {

    private final String[] header;

    protected AbstractListPanel(String[] header) {
        this.header = header;
    }

    protected abstract void initRow(int row, T t);

    public void init(List<T> entityList){
        this.clear();

        for (int i = 0; i < header.length; i++) {
            this.setText(0, i, header[i]);
        }

        if(entityList != null) {
            for (int i = 0; i < entityList.size(); i++) {
                initRow(i + 1, entityList.get(i));
            }
        }

        this.getRowFormatter().addStyleName(0, "entityListHeader");


    }


}
