package com.SSDM.client.ui.myWidget.listEntityFlexTable.deleteStrategy;

import java.util.List;

/**
 * Created by Daniil on 09.12.2016.
 */
public interface DeleteStrategy<T> {
    List<T> delete(T t);
}
