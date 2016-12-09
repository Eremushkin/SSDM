package com.SSDM.client.ui.myWidget;

import com.google.gwt.user.client.ui.ListBox;

import java.util.HashMap;
import java.util.Map;

public class ListBoxCache<T> extends ListBox {
    Map<String, T> cache;

    public ListBoxCache() {
        this.cache = new HashMap<>();
    }

    public void addObject(T t){
        cache.put(t.toString(), t);
        this.addItem(t.toString());
    }

    public void addAllObject(Iterable<T> objects){
        for (T object : objects) {
            addObject(object);
        }

    }

    public T getSelectedObject(){
        String s = this.getSelectedValue();
        return cache.get(s);
    }
}
