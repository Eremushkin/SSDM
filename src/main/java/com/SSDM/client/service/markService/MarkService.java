package com.SSDM.client.service.markService;

import com.SSDM.model.entityVO.MarkVO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MarkService")
public interface MarkService extends RemoteService {

    void addOrUpdate(MarkVO markVO);
    void delete(long id);

    class App {
        private static MarkServiceAsync ourInstance = GWT.create(MarkService.class);
        public static synchronized MarkServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
