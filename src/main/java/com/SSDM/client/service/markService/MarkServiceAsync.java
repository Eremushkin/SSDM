package com.SSDM.client.service.markService;

import com.SSDM.model.entityVO.MarkVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Daniil on 06.12.2016.
 */
public interface MarkServiceAsync {
    void addOrUpdate(MarkVO markVO, AsyncCallback<Void> async);

    void delete(long id, AsyncCallback<Void> async);
}
