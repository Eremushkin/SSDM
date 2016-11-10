package com.SSDM.client.ui;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;

public class MyAsyncCallback implements AsyncCallback<Void> {
    Label label;

    public MyAsyncCallback(Label label) {
        this.label = label;
    }
    public void onSuccess(Void string) {
        label.setText("Yeeeaaaa");
    }
    public void onFailure(Throwable throwable) {
        label.setText(throwable.getMessage());
    }
}