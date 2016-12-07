package com.SSDM.client.ui.panel.addPanel.addPanelWidget.checkBoxList;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;

import java.util.ArrayList;
import java.util.List;


public class CheckBoxListCache<T> extends AbstractCheckBoxList<T> {

    private List<T> cache;
    private AbstractCheckBoxList<String> checkBoxListImpl;

    public CheckBoxListCache() {
        super();
        cache = new ArrayList<>();
        checkBoxListImpl = new CheckBoxList();
        add(checkBoxListImpl);
    }

    @Override
    public void addItem(T t) {
        cache.add(t);
        checkBoxListImpl.addItem(t.toString());
    }

    public void addItem(String name, T t){
        cache.add(t);
        checkBoxListImpl.addItem(name);
    }

    @Override
    public List<CheckBox> getSelectedItem() {
        return checkBoxListImpl.getSelectedItem();
    }

    public List<T> getSelectedObject(){
        List<CheckBox> tmpCheckBoxes = checkBoxListImpl.getCheckBoxList();
        List<T> ans = new ArrayList<>();

        for (int i = 0; i < tmpCheckBoxes.size(); i++) {
            if(tmpCheckBoxes.get(i).getValue())
                ans.add(cache.get(i));
        }

        return ans;
    }

    public void addAll(List<T> objects){
        for (T object : objects) {
            addItem(object);
        }
    }
}
