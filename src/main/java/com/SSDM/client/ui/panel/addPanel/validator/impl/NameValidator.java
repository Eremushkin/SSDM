package com.SSDM.client.ui.panel.addPanel.validator.impl;

import com.SSDM.client.ui.panel.addPanel.validator.Validator;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

public class NameValidator implements Validator{

    private static NameValidator validator;

    private static final String NAME_MESSAGE_ERROR = "может содержать только символы а-я, А-Я, a-z, A-Z";

    private NameValidator() {

    }


    public static Validator getValidator() {
        if(validator == null)
            validator = new NameValidator();
        return validator;
    }

    @Override
    public boolean validate(String text) {
        RegExp regExp = RegExp.compile("[a-zA-Zа-яА-Я]{3,30}","g");
        MatchResult matchResult = regExp.exec(text);
        return matchResult != null && matchResult.getGroup(0).length() == text.length();
    }

    @Override
    public String getErrorMessage(String text) {
        return text + " " + NAME_MESSAGE_ERROR;
    }
}
