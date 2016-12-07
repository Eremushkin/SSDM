package com.SSDM.client.ui.panel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by Daniil on 23.11.2016.
 */
public class UploadFilePanel {

    public VerticalPanel getPanel(){
        final FormPanel formPanel = new FormPanel();
        formPanel.setAction("/SSDM/FileUpload");
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setMethod(FormPanel.METHOD_POST);


        VerticalPanel verticalPanel = new VerticalPanel();
        formPanel.setWidget(verticalPanel);

        final FileUpload fileUpload = new FileUpload();

        Button uploadButton = new Button("Upload");
        uploadButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                formPanel.submit();
            }
        });

        formPanel.addSubmitHandler(new FormPanel.SubmitHandler() {
            public void onSubmit(FormPanel.SubmitEvent event) {

            }
        });

        formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                Window.alert(event.getResults());
            }
        });

        verticalPanel.add(fileUpload);
        verticalPanel.add(uploadButton);

        return verticalPanel;
    }
}
