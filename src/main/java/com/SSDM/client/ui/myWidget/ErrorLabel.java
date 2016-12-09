package com.SSDM.client.ui.myWidget;

import com.google.gwt.user.client.ui.Label;

/**
 * Created by Daniil on 02.12.2016.
 */
public class ErrorLabel extends Label {

    public ErrorLabel(String text) {
        super(text);
        getElement().getStyle().setColor("red");
        setVisible(false);

    }
}
