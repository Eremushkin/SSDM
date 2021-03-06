package com.SSDM.client.ui.myWidget;

import com.SSDM.client.ui.panel.addPanel.validator.Validator;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by Daniil on 02.12.2016.
 */
public class ValidateTextBox extends TextBox {

    private Validator validator;

    private boolean isValidText;

    public ValidateTextBox(final Validator validator) {
        this.validator = validator;
        this.isValidText = false;
        addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                isValidText = validator.validate(getText());
            }
        });
    }

    public boolean isValidText() {
        return isValidText;
    }

    public void addErrorLableChangeHandler(final Label errorLabel){
        this.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                errorLabel.setVisible(!isValidText());
            }
        });
    }
}
