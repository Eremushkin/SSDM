package com.SSDM.client.ui.myWidget.checkBoxList;

import com.google.gwt.user.client.ui.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxList extends AbstractCheckBoxList<String> {


    public CheckBoxList() {
        super();
    }

    public List<CheckBox> getSelectedItem(){
        List<CheckBox> selectedItems = new ArrayList<>();
        for (CheckBox checkBox : checkBoxList) {
            if(checkBox.getValue()) {
                selectedItems.add(checkBox);
            }
        }
        return selectedItems;
    }

    public void addItem(String text){
        CheckBox newCheckBox = new CheckBox(text);
        checkBoxList.add(newCheckBox);
        this.add(newCheckBox);
    }

}
