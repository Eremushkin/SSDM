package com.SSDM.client.ui.myWidget.checkBoxList;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniil on 05.12.2016.
 */
public abstract class AbstractCheckBoxList<T> extends VerticalPanel {

    protected List<CheckBox> checkBoxList;

    public AbstractCheckBoxList(){
        checkBoxList = new ArrayList<>();
    }

    public abstract void addItem(T t);
    public abstract List<CheckBox> getSelectedItem();

    public List<CheckBox> getCheckBoxList() {
        return checkBoxList;
    }

}
