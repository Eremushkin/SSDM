package com.SSDM.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletException;

/**
 * Created by Daniil on 07.11.2016.
 */
public abstract class AutowiringRemoteServiceServlet extends RemoteServiceServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        final WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        if (webApplicationContext == null) {
            throw new IllegalStateException("No Spring web application context found");
        }

        webApplicationContext.getAutowireCapableBeanFactory().autowireBeanProperties(this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }


}
