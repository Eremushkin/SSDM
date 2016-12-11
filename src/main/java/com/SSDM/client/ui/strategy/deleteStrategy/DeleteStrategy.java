package com.SSDM.client.ui.strategy.deleteStrategy;

import com.SSDM.client.ui.myWidget.listEntityFlexTable.AbstractListEntityFlexTable;

/**
 * Created by Daniil on 09.12.2016.
 */
public interface DeleteStrategy<T> {
    void delete(AbstractListEntityFlexTable<T> abstractListEntityFlexTable, T t);
}
