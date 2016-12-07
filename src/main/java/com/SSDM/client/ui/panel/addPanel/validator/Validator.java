package com.SSDM.client.ui.panel.addPanel.validator;

/**
 * Created by Daniil on 02.12.2016.
 */
public interface Validator {
    boolean validate(String text);
    String getErrorMessage(String text);
}
